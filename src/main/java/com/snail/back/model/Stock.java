package com.snail.back.model;

import com.snail.back.entity.StockEntity;

public class Stock {
    private Long id;
    private Long date;
    private String name;
    private Integer cost;

    public Stock() {
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public static Stock toModel(StockEntity entity) {
        Stock model = new Stock();

        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setDate(entity.getDate());
        model.setCost(entity.getCost());

        return model;
    }
}
