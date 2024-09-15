package com.diplomski.reactive.service;

import com.diplomski.reactive.model.StockOption;
import com.diplomski.reactive.model.StockQuote;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CacheService {

    private final ReactiveRedisOperations<String, StockQuote> stockQuoteRedisOperations;
    private final ReactiveRedisOperations<String, StockOption> stockOptionRedisOperations;

    public Mono<StockQuote> cache(final StockQuote stockQuote) {
        return stockQuoteRedisOperations
                .opsForValue()
                .set(UUID.randomUUID().toString(), stockQuote)
                .map((a) -> stockQuote);
    }

    public Mono<StockOption> cache(final StockOption stockOption) {
        return stockOptionRedisOperations
                .opsForValue()
                .set(stockOption.getId().toString(), stockOption)
                .map((a) -> stockOption);
    }
}
