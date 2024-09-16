package com.diplomski.non_reactive.ucecase;

import com.diplomski.non_reactive.model.StockQuote;
import com.diplomski.non_reactive.service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class CacheStockQuoteUseCase {

    private final CacheService cacheService;

    public StockQuote cache(final StockQuote stockQuote) {
        return cacheService.cache(stockQuote);
    }
}
