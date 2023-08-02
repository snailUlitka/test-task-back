package com.snail.back.converter;

import com.snail.back.dto.Stock;
import com.snail.back.entity.StockEntity;

public class StockConverter {
    public static Stock toModel(StockEntity entity) {
        Stock model = new Stock();

        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setDate(entity.getDate());
        model.setCost(entity.getCost());

        return model;
    }
}
