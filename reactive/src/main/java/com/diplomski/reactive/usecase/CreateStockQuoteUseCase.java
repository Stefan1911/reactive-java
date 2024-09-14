package com.diplomski.reactive.usecase;

import com.diplomski.reactive.model.StockQuote;
import com.diplomski.reactive.persistence.StockQuoteRepository;
import com.diplomski.reactive.service.CacheService;
import com.diplomski.reactive.service.DownstreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple3;

@Service
@RequiredArgsConstructor
public class CreateStockQuoteUseCase {

    private final StockQuoteRepository repository;

    private final CacheService cacheService;

    private final DownstreamService downstreamService;

    public Mono<StockQuote> create(final StockQuote stockQuote) {
        return Mono.zip(
                downstreamService.send(stockQuote),
                cacheService.cache(stockQuote),
                repository.persist(stockQuote)
        ).map(Tuple3::getT3);
    }
}
