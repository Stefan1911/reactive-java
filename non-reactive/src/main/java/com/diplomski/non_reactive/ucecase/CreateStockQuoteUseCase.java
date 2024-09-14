package com.diplomski.non_reactive.ucecase;

import com.diplomski.non_reactive.model.StockQuote;
import com.diplomski.non_reactive.persistence.StockQuoteRepository;
import com.diplomski.non_reactive.service.CacheService;
import com.diplomski.non_reactive.service.MessageQueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStockQuoteUseCase {

    private final StockQuoteRepository repository;

    private final CacheService cacheService;

    private final MessageQueueService messageQueueService;

    public StockQuote create(final StockQuote stockQuote) {
        messageQueueService.sendMessage(stockQuote);
        cacheService.cache(stockQuote);

        return repository.persist(stockQuote);
    }
}
