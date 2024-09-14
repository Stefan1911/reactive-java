package com.diplomski.non_reactive.controller;

import com.diplomski.non_reactive.model.StockQuote;
import com.diplomski.non_reactive.ucecase.CreateStockQuoteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/quote")
@RequiredArgsConstructor
public class StockQuoteController {

    private final CreateStockQuoteUseCase createStockQuoteUsecase;

    @PostMapping
    public ResponseEntity<StockQuote> create(@RequestBody StockQuote stockQuote) throws ExecutionException, InterruptedException {
        var useCaseResponse = createStockQuoteUsecase.create(stockQuote);

        return ResponseEntity.ok(useCaseResponse);
    }
}
