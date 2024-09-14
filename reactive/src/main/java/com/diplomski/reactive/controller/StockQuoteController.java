package com.diplomski.reactive.controller;

import com.diplomski.reactive.model.StockQuote;
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

    @PostMapping
    public Mono<ResponseEntity<StockQuote>> create(@RequestBody StockQuote stockQuote) {
        return createStockQuoteUsecase.create(stockQuote)
                .map(ResponseEntity::ok);
    }
}
