package com.diplomski.non_reactive.persistence.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockOptionEntityRepository extends JpaRepository<StockOptionEntity,Integer> {

}