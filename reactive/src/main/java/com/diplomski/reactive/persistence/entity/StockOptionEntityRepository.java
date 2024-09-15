package com.diplomski.reactive.persistence.entity;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockOptionEntityRepository extends ReactiveCrudRepository<StockOptionEntity, Integer> {
}
