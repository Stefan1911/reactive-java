package com.diplomski.reactive.usecase;

import com.diplomski.reactive.model.StockQuote;
import com.diplomski.reactive.persistence.StockQuoteRepository;
import com.diplomski.reactive.service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Service
@RequiredArgsConstructor
public class CreateStockQuoteUseCase {

    private final StockQuoteRepository repository;

    private final CacheService cacheService;

    public Mono<StockQuote> create(final StockQuote stockQuote) {
        return Mono.zip(
                cacheService.cache(stockQuote),
                repository.persist(stockQuote)
        ).map(Tuple2::getT2);
    }
}
