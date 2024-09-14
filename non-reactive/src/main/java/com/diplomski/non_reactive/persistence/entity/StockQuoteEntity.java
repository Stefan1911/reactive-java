package com.diplomski.non_reactive.persistence.entity;

import com.diplomski.non_reactive.model.StockQuote;
import jakarta.persistence.*;
import lombok.*;

@Table(name ="quote")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockQuoteEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "quote_id_gen")
    @SequenceGenerator(name = "quote_id_gen", sequenceName = "quote_id_seq", allocationSize = 1)
    private int id;

    private String company;

    private String ticker;

    @Column(name = "stock_exchange")
    private String stockExchange;

    @Column(name = "quote_price")
    private Float quotePrice;

    @Column(name = "previous_close")
    private Float previousClose;

    @Column(name = "daily_change")
    private Float dailyChange;

    @Column(name = "daily_change_percent")
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
