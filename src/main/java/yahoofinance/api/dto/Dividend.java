package yahoofinance.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dividend {
    private BigDecimal amount;
    private Long date;

    // getters / setters
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public Long getDate() { return date; }
    public void setDate(Long date) { this.date = date; }
}
