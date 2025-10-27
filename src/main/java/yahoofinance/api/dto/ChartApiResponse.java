package yahoofinance.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChartApiResponse {
    private Chart chart;

    // getters / setters
    public Chart getChart() { return chart; }
    public void setChart(Chart chart) { this.chart = chart; }
}
