package com.diplomski.non_reactive.service;

import com.diplomski.non_reactive.model.StockOption;
import com.diplomski.non_reactive.model.StockQuote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class DownstreamService {

    private final RestTemplate restTemplate;

    private final static String QUOTE_ENDPOINT = "http://localhost:8082/api/v1/downstream/quote";
    private final static String OPTION_ENDPOINT = "http://localhost:8082/api/v1/downstream/option";

    public StockQuote send(final StockQuote stockQuote) {
        return restTemplate.postForObject(QUOTE_ENDPOINT, stockQuote, StockQuote.class);
    }

    public StockOption calculatePrice(final StockOption stockOption) {
        return restTemplate.postForObject(OPTION_ENDPOINT, stockOption, StockOption.class);
    }
}
