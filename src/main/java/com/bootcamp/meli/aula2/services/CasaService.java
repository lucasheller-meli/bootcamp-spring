package com.bootcamp.meli.aula2.services;

import com.bootcamp.meli.aula2.controllers.response.CasaResponse;
import com.bootcamp.meli.aula2.entities.Casa;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CasaService {


    public CasaResponse verificarCasa(Casa casa) {

        final HashMap<String, Float> metrosPorComodo = new HashMap();
        casa.getComodos().forEach(c -> metrosPorComodo.put(c.getNome(), c.getComprimento() * c.getLargura()));

        final List<Float> metrosQuadradosComodos = casa.getComodos()
                .stream()
                .map(c -> (c.getComprimento() * c.getLargura())).collect(Collectors.toList());

        final var areaTotal = metrosQuadradosComodos.stream().mapToDouble(Float::doubleValue).sum();

        return CasaResponse.builder()
                .valorDaCasa(areaTotal * 800)
                .totalMetrosQuadrados(areaTotal)
                .metrosPorComodo(metrosPorComodo)
                .maiorComodo(verificaMaiorComodo(metrosPorComodo, Collections.max(metrosQuadradosComodos)))
                .build();

    }

    private String verificaMaiorComodo(HashMap<String, Float> metrosPorComodo, Float areaMaiorComodo) {
        var maiorComodo = "";
        for (Map.Entry<String, Float> entry : metrosPorComodo.entrySet()) {
            if (entry.getValue().equals(areaMaiorComodo))
                maiorComodo = entry.getKey();
        }
        return maiorComodo;
    }

}
