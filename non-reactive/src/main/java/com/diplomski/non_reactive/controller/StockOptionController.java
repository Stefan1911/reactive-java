package com.diplomski.non_reactive.controller;

import com.diplomski.non_reactive.model.StockOption;
import com.diplomski.non_reactive.ucecase.CreateStockOptionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/option")
@RequiredArgsConstructor
public class StockOptionController {

    private final CreateStockOptionUseCase createStockOptionUseCase;

    @PostMapping
    public ResponseEntity<StockOption> create(@RequestBody StockOption stockOption) throws InterruptedException {
        var useCaseResponse = createStockOptionUseCase.create(stockOption);

        return ResponseEntity.ok(useCaseResponse);
    }
}
