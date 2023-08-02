package com.snail.back.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Stock {
    private Long id;
    private Long date;
    private String name;
    private Integer cost;
}
