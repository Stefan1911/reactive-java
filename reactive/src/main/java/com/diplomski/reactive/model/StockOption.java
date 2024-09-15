package com.diplomski.reactive.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StockOption {

    private final Integer id;

    private final Float callOptionPrice;

    private final Float currentStockPrice;

    private final Float strikePrice;

    private final Float riskFreeInterestRate;

    private final Integer timeToMaturity;

    private final Float evaluatedPrice;
}
