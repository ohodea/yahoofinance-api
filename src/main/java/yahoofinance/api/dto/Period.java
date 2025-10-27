package yahoofinance.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Period {
    private String timezone;
    private Long start;
    private Long end;
    private Integer gmtoffset;

    // getters / setters
    public String getTimezone() { return timezone; }
    public void setTimezone(String timezone) { this.timezone = timezone; }
    public Long getStart() { return start; }
    public void setStart(Long start) { this.start = start; }
    public Long getEnd() { return end; }
    public void setEnd(Long end) { this.end = end; }
    public Integer getGmtoffset() { return gmtoffset; }
    public void setGmtoffset(Integer gmtoffset) { this.gmtoffset = gmtoffset; }
}
