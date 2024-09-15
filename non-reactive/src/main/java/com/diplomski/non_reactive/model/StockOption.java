package com.diplomski.non_reactive.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class StockOption {

    private Integer id;

    private Float callOptionPrice;

    private Float currentStockPrice;

    private Float strikePrice;

    private Float riskFreeInterestRate;

    private Integer timeToMaturity;

    private Float evaluatedPrice;
}
