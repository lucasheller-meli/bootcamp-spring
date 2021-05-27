package com.bootcamp.meli.aula2.controllers.response;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class CasaResponse {

    private Double totalMetrosQuadrados;
    private Double valorDaCasa;
    private String maiorComodo;
    private Map<String, Float> metrosPorComodo;
}
