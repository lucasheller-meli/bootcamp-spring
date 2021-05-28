package com.exemplo.aula2.tarde.ex2.controllers.requests;

import com.exemplo.aula2.tarde.ex2.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableRequest {
    private List<Order> orders;
}
