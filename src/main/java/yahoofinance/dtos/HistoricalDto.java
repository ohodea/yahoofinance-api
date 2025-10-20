package yahoofinance.dtos;

import java.util.List;

public class HistoricalDto
{
    private List<HistoricalQuote> quotesList;
    private List <HistoricalDividend> dividendsList;
    private List<HistoricalSplit> splitsList;

    public HistoricalDto(List<HistoricalQuote> quotesList, List<HistoricalDividend> dividendsList, List<HistoricalSplit> splitsList)
    {
        this.quotesList = quotesList;
        this.dividendsList = dividendsList;
        this.splitsList = splitsList;
    }

    public List<HistoricalQuote> getQuotesList()
    {
        return quotesList;
    }

    public void setQuotesList(List<HistoricalQuote> quotesList)
    {
        this.quotesList = quotesList;
    }

    public List<HistoricalDividend> getDividendsList()
    {
        return dividendsList;
    }

    public void setDividendsList(List<HistoricalDividend> dividendsList)
    {
        this.dividendsList = dividendsList;
    }

    public List<HistoricalSplit> getSplitsList()
    {
        return splitsList;
    }

    public void setSplitsList(List<HistoricalSplit> splitsList)
    {
        this.splitsList = splitsList;
    }
}
