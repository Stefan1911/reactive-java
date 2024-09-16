package com.diplomski.reactive.usecase;

import com.diplomski.reactive.model.StockQuote;
import com.diplomski.reactive.service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CacheStockQuoteUseCase {

    private final CacheService cacheService;

    public Mono<StockQuote> cache(final StockQuote stockQuote) {
        return cacheService.cache(stockQuote);
    }
}
