package com.diplomski.reactive.persistence;

import com.diplomski.reactive.model.StockQuote;
import com.diplomski.reactive.persistence.entity.StockQuoteEntity;
import com.diplomski.reactive.persistence.entity.StockQuoteEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class StockQuoteRepository {

    private final StockQuoteEntityRepository entityRepository;

    public Mono<StockQuote> persist(StockQuote stockQuote) {
        final var stockQuoteEntity = new StockQuoteEntity(stockQuote);

        return entityRepository.save(stockQuoteEntity)
                .map(StockQuoteEntity::toDomainModel);
    }
}
