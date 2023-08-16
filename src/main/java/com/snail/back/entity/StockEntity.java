package com.snail.back.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "STOCKS")
public class StockEntity {

    @Id
    @Column(value = "ID")
    private Long id;

    @Column(value = "DATE")
    private Long date;

    @Column(value = "NAME")
    private String name;

    @Column(value = "COST")
    private Integer cost;
}
