package com.diplomski.non_reactive.ucecase;

import com.diplomski.non_reactive.model.StockOption;
import com.diplomski.non_reactive.persistence.StockOptionRepository;
import com.diplomski.non_reactive.service.CacheService;
import com.diplomski.non_reactive.service.DownstreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStockOptionUseCase {

    private final StockOptionRepository repository;

    private final CacheService cacheService;

    private final DownstreamService downstreamService;

    public StockOption create(final StockOption stockOption) {
        var optionWithPrice = downstreamService.calculatePrice(stockOption);

        var persistedStockOption = repository.persist(optionWithPrice);

        return cacheService.cache(persistedStockOption);
    }
}
