package com.diplomski.downstream.controller;

import com.diplomski.downstream.model.StockQuote;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/downstream")
public class DownstreamController {

    @PostMapping
    public ResponseEntity<StockQuote> create(@RequestBody StockQuote stockQuote) throws InterruptedException {
        Thread.sleep(200);

        System.out.println("recieved request: " + stockQuote.toString());
        return ResponseEntity.ok(stockQuote);
    }
}
