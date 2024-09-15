package com.diplomski.reactive.persistence;

import com.diplomski.reactive.model.StockOption;
import com.diplomski.reactive.model.StockQuote;
import com.diplomski.reactive.persistence.entity.StockOptionEntity;
import com.diplomski.reactive.persistence.entity.StockOptionEntityRepository;
import com.diplomski.reactive.persistence.entity.StockQuoteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class StockOptionRepository {

    private final StockOptionEntityRepository entityRepository;

    public Mono<StockOption> persist(StockOption stockOption) {
        final var stockOptionEntity = new StockOptionEntity(stockOption);

        return entityRepository.save(stockOptionEntity)
                .map(StockOptionEntity::toDomainModel);
    }
}
