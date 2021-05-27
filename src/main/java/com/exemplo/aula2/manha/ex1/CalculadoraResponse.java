package com.exemplo.aula2.manha.ex1;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Map;

@Data
@AllArgsConstructor
public class CalculadoraResponse {
    private Double totalMetrosQuadrados;
    private Double valorCasa;
    private Comodo maiorComodo;
    private Map<String, Double> metrosPorComodo;
}
