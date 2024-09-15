package com.diplomski.reactive.persistence.entity;

import com.diplomski.reactive.model.StockOption;
import com.diplomski.reactive.model.StockQuote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("option")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockOptionEntity {

    @Id
    private int id;

    @Column("call_option_price")
    private Float callOptionPrice;

    @Column("current_stock_price")
    private Float currentStockPrice;

    @Column("trike_price")
    private Float strikePrice;

    @Column("risk_free_interest_rate")
    private Float riskFreeInterestRate;

    @Column("time_to_maturity")
    private Integer timeToMaturity;

    @Column("evaluated_price")
    private Float evaluatedPrice;

    public StockOptionEntity(StockOption stockOption) {
        this.callOptionPrice = stockOption.getCallOptionPrice();
        this.currentStockPrice = stockOption.getCurrentStockPrice();
        this.strikePrice = stockOption.getStrikePrice();
        this.riskFreeInterestRate = stockOption.getRiskFreeInterestRate();
        this.timeToMaturity = stockOption.getTimeToMaturity();
        this.evaluatedPrice = stockOption.getEvaluatedPrice();
    }

    public StockOption toDomainModel() {
        return new StockOption(
                this.id,
                this.callOptionPrice,
                this.currentStockPrice,
                this.strikePrice,
                this.riskFreeInterestRate,
                this.timeToMaturity,
                this.evaluatedPrice);
    }
}
