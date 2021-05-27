package com.bootcamp.meli.services;

import com.bootcamp.meli.controllers.response.CasaResponse;
import com.bootcamp.meli.entities.Casa;
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
        casa.getComodos().forEach(c -> {
            metrosPorComodo.put(c.getNome(), c.getComprimento() * c.getLargura());
        });

        final List<Float> metrosQuadrados = casa.getComodos()
                .stream()
                .map(c -> (c.getComprimento() * c.getLargura())).collect(Collectors.toList());


        var total = metrosQuadrados.stream().mapToDouble(Float::doubleValue).sum();

        return CasaResponse.builder()
                .valorDaCasa(total * 800)
                .totalMetrosQuadrados(total)
                .metrosPorComodo(metrosPorComodo)
                .maiorComodo(maiorComodo(metrosPorComodo, Collections.max(metrosQuadrados)))
                .build();

    }

    private String maiorComodo(HashMap<String, Float> metrosPorComodo, Float areaMaiorComodo) {
        var maiorComodo = "";
        for (Map.Entry<String, Float> entry : metrosPorComodo.entrySet()) {
            if (entry.getValue().equals(areaMaiorComodo))
                maiorComodo = entry.getKey();
        }
        return maiorComodo;
    }

}
