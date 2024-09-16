package com.diplomski.reactive.controller;

import com.diplomski.reactive.model.StockQuote;
import com.diplomski.reactive.usecase.CacheStockQuoteUseCase;
import com.diplomski.reactive.usecase.CreateStockQuoteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/quote")
@RequiredArgsConstructor
public class StockQuoteController {

    private final CreateStockQuoteUseCase createStockQuoteUsecase;

    private final CacheStockQuoteUseCase cacheStockQuoteUseCase;

    @PostMapping
    public Mono<ResponseEntity<StockQuote>> create(@RequestBody StockQuote stockQuote) {
        return createStockQuoteUsecase.create(stockQuote)
                .map(ResponseEntity::ok);
    }

    @PostMapping("/cache")
    public Mono<ResponseEntity<StockQuote>> cache(@RequestBody StockQuote stockQuote) {
        return cacheStockQuoteUseCase.cache(stockQuote)
                .map(ResponseEntity::ok);
    }
}
