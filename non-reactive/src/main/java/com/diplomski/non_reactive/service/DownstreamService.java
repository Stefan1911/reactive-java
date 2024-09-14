package com.diplomski.non_reactive.service;

import com.diplomski.non_reactive.model.StockQuote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class DownstreamService {

    private final RestTemplate restTemplate;

    private final static String ENDPOINT = "http://localhost:8082/api/v1/downstream";

    public StockQuote send(final StockQuote stockQuote) {
        return restTemplate.postForObject(ENDPOINT, stockQuote, StockQuote.class);
    }
}
