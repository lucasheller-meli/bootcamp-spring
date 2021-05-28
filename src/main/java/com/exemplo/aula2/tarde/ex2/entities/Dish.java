package com.exemplo.aula2.tarde.ex2.entities;

import lombok.Data;

@Data
public class Dish {
    private Long id;
    private Double price;
    private String description;
    private Integer quantity;
}
