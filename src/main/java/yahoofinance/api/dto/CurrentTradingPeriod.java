package yahoofinance.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentTradingPeriod {
    private Period pre;
    private Period regular;
    private Period post;

    // getters / setters
    public Period getPre() { return pre; }
    public void setPre(Period pre) { this.pre = pre; }
    public Period getRegular() { return regular; }
    public void setRegular(Period regular) { this.regular = regular; }
    public Period getPost() { return post; }
    public void setPost(Period post) { this.post = post; }
}
