package com.exemplo.aula2.tarde.ex2.entities;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Table {
    private Long id;
    private List<Order> orders;
    private Double totalPrice;
}
