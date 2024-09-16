package com.diplomski.reactive.service;

import com.diplomski.reactive.model.StockOption;
import com.diplomski.reactive.model.StockQuote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DownstreamService {

    private final WebClient webClient;

    private final static String QUOTE_ENDPOINT = "http://localhost:8082/api/v1/downstream/quote";
    private final static String CALCULATE_OPTION_ENDPOINT = "http://localhost:8082/api/v1/downstream/calculate/option";
    private final static String OPTION_ENDPOINT = "http://localhost:8082/api/v1/downstream/option";

    public Mono<StockQuote> send(final StockQuote stockQuote) {
        return webClient.post()
                .uri(QUOTE_ENDPOINT)
                .bodyValue(stockQuote)
                .retrieve()
                .bodyToMono(StockQuote.class);
    }

    public Mono<StockOption> send(final StockOption stockOption) {
        return webClient.post()
                .uri(OPTION_ENDPOINT)
                .bodyValue(stockOption)
                .retrieve()
                .bodyToMono(StockOption.class);
    }

    public Mono<StockOption> calculatePrice(final StockOption stockOption) {
        return webClient.post()
                .uri(CALCULATE_OPTION_ENDPOINT)
                .bodyValue(stockOption)
                .retrieve()
                .bodyToMono(StockOption.class);
    }
}
