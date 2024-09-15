package com.diplomski.non_reactive.persistence;

import com.diplomski.non_reactive.model.StockOption;
import com.diplomski.non_reactive.persistence.entity.StockOptionEntity;
import com.diplomski.non_reactive.persistence.entity.StockOptionEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StockOptionRepository {

    private final StockOptionEntityRepository entityRepository;

    public StockOption persist(StockOption stockOption) {
        final var stockOptionEntity = new StockOptionEntity(stockOption);

        var persistedEntity = entityRepository.save(stockOptionEntity);

        return persistedEntity.toDomainModel();
    }
}
