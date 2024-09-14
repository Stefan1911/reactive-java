package com.diplomski.non_reactive.persistence;

import com.diplomski.non_reactive.model.StockQuote;
import com.diplomski.non_reactive.persistence.entity.StockQuoteEntity;
import com.diplomski.non_reactive.persistence.entity.StockQuoteEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StockQuoteRepository {

    private final StockQuoteEntityRepository entityRepository;

    public StockQuote persist(StockQuote stockQuote) {
        final var stockQuoteEntity = new StockQuoteEntity(stockQuote);

        var persistedEntity = entityRepository.save(stockQuoteEntity);

        return persistedEntity.toDomainModel();
    }
}
