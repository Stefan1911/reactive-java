package com.diplomski.reactive.persistence.entity;

import com.diplomski.reactive.model.StockQuote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("quote")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockQuoteEntity {
    
    @Id
    private int id;

    private String company;

    private String ticker;

    @Column("stock_exchange")
    private String stockExchange;

    @Column("quote_price")
    private Float quotePrice;

    @Column("previous_close")
    private Float previousClose;

    @Column("daily_change")
    private Float dailyChange;

    @Column("daily_change_percent")
    private Float dailyChangePercent;

    private Float open;

    private Float bid;

    private Float ask;

    private Float volume;

    public StockQuoteEntity(StockQuote stockQuote) {
       this.company = stockQuote.getCompany();
       this.ticker = stockQuote.getTicker();
       this.stockExchange = stockQuote.getStockExchange();
       this.quotePrice = stockQuote.getQuotePrice();
       this.previousClose = stockQuote.getPreviousClose();
       this.dailyChange = stockQuote.getDailyChange();
       this.dailyChangePercent = stockQuote.getDailyChangePercent();
       this.open = stockQuote.getOpen();
       this.bid = stockQuote.getBid();
       this.ask = stockQuote.getAsk();
       this.volume = stockQuote.getVolume();
    }

    public StockQuote toDomainModel() {
        return new StockQuote(
                this.company,
                this.ticker,
                this.stockExchange,
                this.quotePrice,
                this.previousClose,
                this.dailyChange,
                this.dailyChangePercent,
                this.open,
                this.bid,
                this.ask,
                this.volume);
    }
}
