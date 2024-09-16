package com.diplomski.non_reactive.service;

import com.diplomski.non_reactive.model.StockOption;
import com.diplomski.non_reactive.model.StockQuote;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CacheService {

    private final RedisTemplate<String, String> template;

    public StockQuote cache(final StockQuote stockQuote) {
        template.opsForValue().set(UUID.randomUUID().toString(), stockQuote.toString());

        return stockQuote;
    }

    public StockOption cache(final StockOption stockOption) throws InterruptedException {
        template.opsForValue().set(stockOption.getId().toString(), stockOption.toString());

        //Thread.sleep(100);
        return stockOption;
    }
}
