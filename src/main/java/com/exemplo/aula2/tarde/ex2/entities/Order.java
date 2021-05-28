package com.exemplo.aula2.tarde.ex2.entities;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private Long id;
    private Long tableId;
    private List<Dish> orderedDishes;

    public Double getTotalPrice() {
        return orderedDishes.stream().mapToDouble(dish -> dish.getPrice() * dish.getQuantity()).sum();
    }
}
