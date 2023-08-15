package com.snail.back.entity;


import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "stocks")
public class StockEntity {

    @Id
    @Column(value = "id")
    private Long id;

    @Column(value = "date")
    private Long date;

    @Column(value = "name")
    private String name;

    @Column(value = "cost")
    private Integer cost;
}
