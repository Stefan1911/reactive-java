package com.diplomski.reactive.service;

import com.diplomski.reactive.model.StockQuote;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CacheService {

    private final ReactiveRedisOperations<String, StockQuote> reactiveRedisOperations;

    public Mono<Boolean> cache(final StockQuote stockQuote) {
        return reactiveRedisOperations
                .opsForValue()
                .set(UUID.randomUUID().toString(), stockQuote);
    }
}
