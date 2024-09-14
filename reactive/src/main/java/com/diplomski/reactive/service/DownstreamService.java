package com.diplomski.reactive.service;

import com.diplomski.reactive.model.StockQuote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DownstreamService {

    private final WebClient webClient;

    public Mono<StockQuote> send(final StockQuote stockQuote) {
        return webClient.post()
                .uri("http://localhost:8082/api/v1/downstream")
                .bodyValue(stockQuote)
                .retrieve()
                .bodyToMono(StockQuote.class);
    }
}
