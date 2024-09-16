package com.diplomski.reactive.usecase;

import com.diplomski.reactive.model.StockOption;
import com.diplomski.reactive.persistence.StockOptionRepository;
import com.diplomski.reactive.service.DownstreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateStockOptionUseCase {

    private final StockOptionRepository repository;

    private final DownstreamService downstreamService;

    public Mono<StockOption> create(final StockOption stockQuote) {
        return downstreamService.calculatePrice(stockQuote)
                .flatMap(repository::persist)
                .flatMap(downstreamService::send);
    }
}
