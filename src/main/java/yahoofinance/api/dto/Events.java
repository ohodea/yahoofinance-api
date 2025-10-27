package yahoofinance.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Events {
    private Map<String, Split> splits;
    private Map<String, Dividend> dividends;

    // getters / setters
    public Map<String, Split> getSplits() { return splits; }
    public void setSplits(Map<String, Split> splits) { this.splits = splits; }
    public Map<String, Dividend> getDividends() { return dividends; }
    public void setDividends(Map<String, Dividend> dividends) { this.dividends = dividends; }
}
