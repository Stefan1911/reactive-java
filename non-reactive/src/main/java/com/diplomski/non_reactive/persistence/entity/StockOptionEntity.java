package com.diplomski.non_reactive.persistence.entity;

import com.diplomski.non_reactive.model.StockOption;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name ="option")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockOptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "option_id_gen")
    @SequenceGenerator(name = "option_id_gen", sequenceName = "option_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "call_option_price")
    private Float callOptionPrice;

    @Column(name = "current_stock_price")
    private Float currentStockPrice;

    @Column(name = "trike_price")
    private Float strikePrice;

    @Column(name = "risk_free_interest_rate")
    private Float riskFreeInterestRate;

    @Column(name = "time_to_maturity")
    private Integer timeToMaturity;

    @Column(name = "evaluated_price")
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
