package yahoofinance.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Chart {
    private List<Result> result;
    private Object error;

    // getters / setters
    public List<Result> getResult() { return result; }
    public void setResult(List<Result> result) { this.result = result; }
    public Object getError() { return error; }
    public void setError(Object error) { this.error = error; }
}
