package com.snail.back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "stocks")
public class StockEntity {
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "date", nullable = false)
    private Long date;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cost", nullable = false)
    private Integer cost;
}
