package yahoofinance.query2v8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;

import com.fasterxml.jackson.databind.DeserializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import yahoofinance.Utils;
import yahoofinance.YahooFinance;
import yahoofinance.api.dto.*;
import yahoofinance.dtos.*;
import yahoofinance.histquotes2.CrumbManager;
import yahoofinance.histquotes2.IntervalMapper;
import yahoofinance.histquotes2.QueryInterval;
import yahoofinance.util.RedirectableRequest;


/**
 * @author Stijn Strickx
 */
public class HistQuotesQuery2V8Request {

    private static final Logger log = LoggerFactory.getLogger(HistQuotesQuery2V8Request.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();



    private final String symbol;
    private final Calendar from;
    private final Calendar to;
    private final QueryInterval interval;

    public static final Calendar DEFAULT_FROM = Calendar.getInstance();

    static {
        DEFAULT_FROM.add(Calendar.YEAR, -1);

        objectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
    }
    public static final Calendar DEFAULT_TO = Calendar.getInstance();
    public static final QueryInterval DEFAULT_INTERVAL = QueryInterval.MONTHLY;

    public HistQuotesQuery2V8Request(String symbol) {
        this(symbol, DEFAULT_INTERVAL);
    }

    public HistQuotesQuery2V8Request(String symbol, QueryInterval interval) {
        this(symbol, DEFAULT_FROM, DEFAULT_TO, interval);
    }


    public HistQuotesQuery2V8Request(String symbol, Calendar from, Calendar to) {
        this(symbol, from, to, DEFAULT_INTERVAL);
    }
    public HistQuotesQuery2V8Request(String symbol, Calendar from, Calendar to, QueryInterval interval) {
        this.symbol = symbol;
        this.from = this.cleanHistCalendar(from);
        this.to = this.cleanHistCalendar(to);
        this.interval = interval;

    }
    public HistQuotesQuery2V8Request(String symbol, Calendar from, Calendar to, Interval interval) {
        this.symbol = symbol;
        this.from = this.cleanHistCalendar(from);
        this.to = this.cleanHistCalendar(to);
        this.interval = IntervalMapper.get(interval);

    }

    public HistQuotesQuery2V8Request(String symbol, Date from, Date to) {
        this(symbol, from, to, DEFAULT_INTERVAL);
    }

    public HistQuotesQuery2V8Request(String symbol, Date from, Date to, QueryInterval interval) {
        this(symbol, interval);
        this.from.setTime(from);
        this.to.setTime(to);
        this.cleanHistCalendar(this.from);
        this.cleanHistCalendar(this.to);
    }

    /**
     * Put everything smaller than days at 0
     * @param cal calendar to be cleaned
     */
    private Calendar cleanHistCalendar(Calendar cal) {
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR, 0);
        return cal;
    }

    public HistoricalDto getResult() throws IOException {
        String json = getJson();
        ChartApiResponse yahooResponse =  objectMapper.readValue(json, ChartApiResponse.class);
        Result yahooQuotes = yahooResponse.getChart().getResult().get(0);
        List<Long> timestampsList = yahooQuotes.getTimestamp();
        Quote quote = yahooQuotes.getIndicators().getQuote().get(0);

        AdjClose adjClose = yahooQuotes.getIndicators().getAdjclose().get(0);

        List<HistoricalQuote> quoteListToBeReturned = new ArrayList<>();

        if(timestampsList ==null)
        {
            return new HistoricalDto(quoteListToBeReturned, Collections.emptyList(), Collections.emptyList());
        }

        for (int i = 0; i < timestampsList.size(); i++)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(timestampsList.get(i) * 1000);
            quoteListToBeReturned.add(new HistoricalQuote(
                    symbol,
                    calendar,
                    quote.getOpen().get(i),
                    quote.getLow().get(i),
                    quote.getHigh().get(i),
                    quote.getClose().get(i),
                    adjClose.getAdjclose().get(i),
                    quote.getVolume().get(i)));
        }
        Events yahooEvents =  yahooQuotes.getEvents();
        List<HistoricalDividend> dividentsListToBeReturned = new ArrayList<>();
        List<HistoricalSplit> splitListToBeReturned = new ArrayList<>();
        if(yahooEvents != null)
        {
            Map<String, Dividend> dividentsMap = yahooEvents.getDividends();
            if(dividentsMap !=null)
            {

                for (Dividend divident : dividentsMap.values())
                {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(divident.getDate() * 1000);
                    dividentsListToBeReturned.add(new HistoricalDividend(
                            symbol,
                            calendar,
                           divident.getAmount()
                    ));
                }
            }

            Map<String, Split> spliMap = yahooEvents.getSplits();

            if(spliMap !=null)
            {

                for (Split split : spliMap.values())
                {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(split.getDate() * 1000);
                    splitListToBeReturned.add(new HistoricalSplit(
                            symbol,
                            calendar,
                            split.getNumerator(),
                            split.getDenominator()
                    ));
                }
            }
        }
        return new HistoricalDto(quoteListToBeReturned,  dividentsListToBeReturned, splitListToBeReturned);
    }

    public String getJson() throws IOException {

        if(this.from.after(this.to)) {
            log.warn("Unable to retrieve historical quotes. "
                    + "From-date should not be after to-date. From: "
                    + this.from.getTime() + ", to: " + this.to.getTime());
            return "";
        }

        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put("period1", String.valueOf(this.from.getTimeInMillis() / 1000));
        params.put("period2", String.valueOf(this.to.getTimeInMillis() / 1000));
        params.put("interval", this.interval.getTag());
        params.put("events", "div|split");

        String url = YahooFinance.HISTQUOTES_QUERY2V8_BASE_URL + URLEncoder.encode(this.symbol , "UTF-8") + "?" + Utils.getURLParameters(params);

        // Get CSV from Yahoo
        log.info("Sending request: " + url);

        URL request = new URL(url);
        RedirectableRequest redirectableRequest = new RedirectableRequest(request, 5);
        redirectableRequest.setConnectTimeout(YahooFinance.CONNECTION_TIMEOUT);
        redirectableRequest.setReadTimeout(YahooFinance.CONNECTION_TIMEOUT);
        Map<String, String> requestProperties = new HashMap<String, String>();
        requestProperties.put("Cookie", CrumbManager.getCookie());
        requestProperties.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/141.0.0.0 Safari/537.36");
        requestProperties.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        requestProperties.put("Accept-Language", "en-US,en;q=0.9");

        URLConnection connection = redirectableRequest.openConnection(requestProperties);

        InputStreamReader is = new InputStreamReader(connection.getInputStream());
        BufferedReader br = new BufferedReader(is);
        StringBuilder builder = new StringBuilder();
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            if (builder.length() > 0) {
                builder.append("\n");
            }
            builder.append(line);
        }
        return builder.toString();
    }

}
