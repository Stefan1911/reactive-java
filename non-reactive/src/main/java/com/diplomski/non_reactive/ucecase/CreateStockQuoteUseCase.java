package com.diplomski.non_reactive.ucecase;

import com.diplomski.non_reactive.model.StockQuote;
import com.diplomski.non_reactive.persistence.StockQuoteRepository;
import com.diplomski.non_reactive.service.CacheService;
import com.diplomski.non_reactive.service.MessageQueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class CreateStockQuoteUseCase {

    private final StockQuoteRepository repository;

    private final CacheService cacheService;

    private final MessageQueueService messageQueueService;

    public StockQuote create(final StockQuote stockQuote) throws InterruptedException, ExecutionException {
        var messagingFuture = CompletableFuture.supplyAsync(() -> messageQueueService.sendMessage(stockQuote));
        var cachingFuture = CompletableFuture.supplyAsync(() -> cacheService.cache(stockQuote));
        var persistenceFuture = CompletableFuture.supplyAsync(() -> repository.persist(stockQuote));

        CompletableFuture<StockQuote> combinedFutures =  persistenceFuture
                .thenCombine(cachingFuture, (persistenceQuote, cachingQuote) -> persistenceQuote)
                .thenCombine(messagingFuture, (persistenceQuote, messagingQuote) -> persistenceQuote);

        return combinedFutures.get();
    }
}
