package com.diplomski.reactive.controller;

import com.diplomski.reactive.model.StockOption;
import com.diplomski.reactive.model.StockQuote;
import com.diplomski.reactive.usecase.CreateStockOptionUseCase;
import com.diplomski.reactive.usecase.CreateStockQuoteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/option")
@RequiredArgsConstructor
public class StockOptionController {

    private final CreateStockOptionUseCase createStockOptionUseCase;

    @PostMapping
    public Mono<ResponseEntity<StockOption>> create(@RequestBody StockOption stockOption) {
        return createStockOptionUseCase.create(stockOption)
                .map(ResponseEntity::ok);
    }
}
