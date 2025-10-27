package yahoofinance.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    private Meta meta;
    private List<Long> timestamp;
    private Events events;
    private Indicators indicators;

    // getters / setters
    public Meta getMeta() { return meta; }
    public void setMeta(Meta meta) { this.meta = meta; }
    public List<Long> getTimestamp() { return timestamp; }
    public void setTimestamp(List<Long> timestamp) { this.timestamp = timestamp; }
    public Events getEvents() { return events; }
    public void setEvents(Events events) { this.events = events; }
    public Indicators getIndicators() { return indicators; }
    public void setIndicators(Indicators indicators) { this.indicators = indicators; }
}
