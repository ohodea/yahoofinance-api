package yahoofinance.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Indicators {
    private List<Quote> quote;
    private List<AdjClose> adjclose;

    // getters / setters
    public List<Quote> getQuote() { return quote; }
    public void setQuote(List<Quote> quote) { this.quote = quote; }
    public List<AdjClose> getAdjclose() { return adjclose; }
    public void setAdjclose(List<AdjClose> adjclose) { this.adjclose = adjclose; }
}
