package com.diplomski.reactive.usecase;

import com.diplomski.reactive.model.StockQuote;
import com.diplomski.reactive.persistence.StockQuoteRepository;
import com.diplomski.reactive.service.CacheService;
import com.diplomski.reactive.service.MessageQueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple3;

@Service
@RequiredArgsConstructor
public class CreateStockQuoteUseCase {

    private final StockQuoteRepository repository;

    private final CacheService cacheService;

    private final MessageQueueService messageQueueService;

    public Mono<StockQuote> create(final StockQuote stockQuote) {
        return Mono.zip(
                messageQueueService.sendMessage(stockQuote),
                cacheService.cache(stockQuote),
                repository.persist(stockQuote)
        ).map(Tuple3::getT3);
    }
}
