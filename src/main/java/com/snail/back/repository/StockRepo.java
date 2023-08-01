package com.snail.back.repository;

import com.snail.back.entity.StockEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface StockRepo extends CrudRepository<StockEntity, Long> {
    ArrayList<StockEntity> findAllByName(String name);

    ArrayList<StockEntity> findByOrderByDate();
}
