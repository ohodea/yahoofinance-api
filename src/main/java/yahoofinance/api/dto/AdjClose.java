package yahoofinance.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.List;


    @JsonIgnoreProperties(ignoreUnknown = true)
    public class AdjClose {
        private List<BigDecimal> adjclose;

        // getters / setters
        public List<BigDecimal> getAdjclose() { return adjclose; }
        public void setAdjclose(List<BigDecimal> adjclose) { this.adjclose = adjclose; }
    }

