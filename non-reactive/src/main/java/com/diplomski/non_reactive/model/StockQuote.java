package com.diplomski.non_reactive.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StockQuote {

    private final String company;

    private final String ticker;

    private final String stockExchange;

    private final Float quotePrice;

    private final Float previousClose;

    private final Float dailyChange;

    private final Float dailyChangePercent;

    private final Float open;

    private final Float bid;

    private final Float ask;

    private final Float volume;
}
