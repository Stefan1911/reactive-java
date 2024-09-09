package com.diplomski.reactive.persistence.entity;

import com.diplomski.reactive.model.StockQuote;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockQuoteEntityRepository extends ReactiveCrudRepository<StockQuoteEntity,Integer> {

}