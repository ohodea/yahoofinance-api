package yahoofinance.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    private List<BigDecimal> low;
    private List<BigDecimal> open;
    private List<Long> volume;
    private List<BigDecimal> high;
    private List<BigDecimal> close;

    // getters / setters
    public List<BigDecimal> getLow() { return low; }
    public void setLow(List<BigDecimal> low) { this.low = low; }
    public List<BigDecimal> getOpen() { return open; }
    public void setOpen(List<BigDecimal> open) { this.open = open; }
    public List<Long> getVolume() { return volume; }
    public void setVolume(List<Long> volume) { this.volume = volume; }
    public List<BigDecimal> getHigh() { return high; }
    public void setHigh(List<BigDecimal> high) { this.high = high; }
    public List<BigDecimal> getClose() { return close; }
    public void setClose(List<BigDecimal> close) { this.close = close; }
}
