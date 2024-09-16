package com.diplomski.downstream.controller;

import com.diplomski.downstream.model.StockOption;
import com.diplomski.downstream.model.StockQuote;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api/v1/downstream")
public class DownstreamController {

    private final static Random RANDOM = new Random();

    @PostMapping("/quote")
    public ResponseEntity<StockQuote> create(@RequestBody StockQuote stockQuote) throws InterruptedException {
        System.out.println("received quote");

        Thread.sleep(200);

        return ResponseEntity.ok(stockQuote);
    }

    @PostMapping("/option")
    public ResponseEntity<StockOption> create(@RequestBody StockOption stockOption) throws InterruptedException {
        System.out.println("received option");

        Thread.sleep(200);

        return ResponseEntity.ok(stockOption);
    }

    @PostMapping("/calculate/option")
    public ResponseEntity<StockOption> calculate(@RequestBody StockOption stockOption) throws InterruptedException {
        System.out.println("received calculate option");

        Thread.sleep(200);

        float evaluatedPrice = RANDOM.nextFloat() * (200 - 100) + 100;
        stockOption.setEvaluatedPrice(evaluatedPrice);

        return ResponseEntity.ok(stockOption);
    }
}

