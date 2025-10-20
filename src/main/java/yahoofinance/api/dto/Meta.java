package yahoofinance.api.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Meta {
    private String currency;
    private String symbol;
    private String exchangeName;
    private String fullExchangeName;
    private String instrumentType;
    private Long firstTradeDate;
    private Long regularMarketTime;
    private Boolean hasPrePostMarketData;
    private Integer gmtoffset;
    private String timezone;
    private String exchangeTimezoneName;
    private BigDecimal regularMarketPrice;
    private BigDecimal fiftyTwoWeekHigh;
    private BigDecimal fiftyTwoWeekLow;
    private BigDecimal regularMarketDayHigh;
    private BigDecimal regularMarketDayLow;
    private Long regularMarketVolume;
    private String longName;
    private String shortName;
    private BigDecimal chartPreviousClose;
    private Integer priceHint;
    private CurrentTradingPeriod currentTradingPeriod;
    private String dataGranularity;
    private String range;
    private List<String> validRanges;

    // getters / setters
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
    public String getExchangeName() { return exchangeName; }
    public void setExchangeName(String exchangeName) { this.exchangeName = exchangeName; }
    public String getFullExchangeName() { return fullExchangeName; }
    public void setFullExchangeName(String fullExchangeName) { this.fullExchangeName = fullExchangeName; }
    public String getInstrumentType() { return instrumentType; }
    public void setInstrumentType(String instrumentType) { this.instrumentType = instrumentType; }
    public Long getFirstTradeDate() { return firstTradeDate; }
    public void setFirstTradeDate(Long firstTradeDate) { this.firstTradeDate = firstTradeDate; }
    public Long getRegularMarketTime() { return regularMarketTime; }
    public void setRegularMarketTime(Long regularMarketTime) { this.regularMarketTime = regularMarketTime; }
    public Boolean getHasPrePostMarketData() { return hasPrePostMarketData; }
    public void setHasPrePostMarketData(Boolean hasPrePostMarketData) { this.hasPrePostMarketData = hasPrePostMarketData; }
    public Integer getGmtoffset() { return gmtoffset; }
    public void setGmtoffset(Integer gmtoffset) { this.gmtoffset = gmtoffset; }
    public String getTimezone() { return timezone; }
    public void setTimezone(String timezone) { this.timezone = timezone; }
    public String getExchangeTimezoneName() { return exchangeTimezoneName; }
    public void setExchangeTimezoneName(String exchangeTimezoneName) { this.exchangeTimezoneName = exchangeTimezoneName; }
    public BigDecimal getRegularMarketPrice() { return regularMarketPrice; }
    public void setRegularMarketPrice(BigDecimal regularMarketPrice) { this.regularMarketPrice = regularMarketPrice; }
    public BigDecimal getFiftyTwoWeekHigh() { return fiftyTwoWeekHigh; }
    public void setFiftyTwoWeekHigh(BigDecimal fiftyTwoWeekHigh) { this.fiftyTwoWeekHigh = fiftyTwoWeekHigh; }
    public BigDecimal getFiftyTwoWeekLow() { return fiftyTwoWeekLow; }
    public void setFiftyTwoWeekLow(BigDecimal fiftyTwoWeekLow) { this.fiftyTwoWeekLow = fiftyTwoWeekLow; }
    public BigDecimal getRegularMarketDayHigh() { return regularMarketDayHigh; }
    public void setRegularMarketDayHigh(BigDecimal regularMarketDayHigh) { this.regularMarketDayHigh = regularMarketDayHigh; }
    public BigDecimal getRegularMarketDayLow() { return regularMarketDayLow; }
    public void setRegularMarketDayLow(BigDecimal regularMarketDayLow) { this.regularMarketDayLow = regularMarketDayLow; }
    public Long getRegularMarketVolume() { return regularMarketVolume; }
    public void setRegularMarketVolume(Long regularMarketVolume) { this.regularMarketVolume = regularMarketVolume; }
    public String getLongName() { return longName; }
    public void setLongName(String longName) { this.longName = longName; }
    public String getShortName() { return shortName; }
    public void setShortName(String shortName) { this.shortName = shortName; }
    public BigDecimal getChartPreviousClose() { return chartPreviousClose; }
    public void setChartPreviousClose(BigDecimal chartPreviousClose) { this.chartPreviousClose = chartPreviousClose; }
    public Integer getPriceHint() { return priceHint; }
    public void setPriceHint(Integer priceHint) { this.priceHint = priceHint; }
    public CurrentTradingPeriod getCurrentTradingPeriod() { return currentTradingPeriod; }
    public void setCurrentTradingPeriod(CurrentTradingPeriod currentTradingPeriod) { this.currentTradingPeriod = currentTradingPeriod; }
    public String getDataGranularity() { return dataGranularity; }
    public void setDataGranularity(String dataGranularity) { this.dataGranularity = dataGranularity; }
    public String getRange() { return range; }
    public void setRange(String range) { this.range = range; }
    public List<String> getValidRanges() { return validRanges; }
    public void setValidRanges(List<String> validRanges) { this.validRanges = validRanges; }
}