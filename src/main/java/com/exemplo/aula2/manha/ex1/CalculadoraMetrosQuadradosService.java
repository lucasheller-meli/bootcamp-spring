package com.exemplo.aula2.manha.ex1;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CalculadoraMetrosQuadradosService {
    public CalculadoraResponse calcular(Casa casa) {
        List<Comodo> comodos = casa.getComodos();

        return new CalculadoraResponse(
                totalMetrosQuadrados(comodos),
                valorCasa(comodos),
                maiorComodo(comodos),
                metrosPorComodo(comodos)
        );
    }

    private Double totalMetrosQuadrados(List<Comodo> comodos) {
        return comodos.stream().mapToDouble(comodo -> comodo.getComprimento() * comodo.getLargura()).sum();
    }

    private Double valorCasa(List<Comodo> comodos) {
        return totalMetrosQuadrados(comodos) * 800;
    }

    private Comodo maiorComodo(List<Comodo> comodos) {
        return comodos.stream().max((previous, current) -> {
            double previousMeters = previous.getComprimento() * previous.getLargura();
            double currentMeters = current.getComprimento() * current.getLargura();
            return Double.compare(previousMeters, currentMeters);
        }).get();
    }

    private Map<String, Double> metrosPorComodo(List<Comodo> comodos) {
        return comodos.stream()
                .collect(Collectors.toMap(Comodo::getNome, comodo -> comodo.getComprimento() * comodo.getLargura()));
    }

}
