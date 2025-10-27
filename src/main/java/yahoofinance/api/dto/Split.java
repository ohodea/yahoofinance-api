package yahoofinance.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Split {
    private Long date;
    private BigDecimal numerator;
    private BigDecimal denominator;
    private String splitRatio;

    // getters / setters
    public Long getDate() { return date; }
    public void setDate(Long date) { this.date = date; }
    public BigDecimal getNumerator() { return numerator; }
    public void setNumerator(BigDecimal numerator) { this.numerator = numerator; }
    public BigDecimal getDenominator() { return denominator; }
    public void setDenominator(BigDecimal denominator) { this.denominator = denominator; }
    public String getSplitRatio() { return splitRatio; }
    public void setSplitRatio(String splitRatio) { this.splitRatio = splitRatio; }
}
