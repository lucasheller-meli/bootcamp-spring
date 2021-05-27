package com.exemplo.aula2.manha.ex1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraMetrosQuadradosController {
    private final CalculadoraMetrosQuadradosService calculadora;

    public CalculadoraMetrosQuadradosController(CalculadoraMetrosQuadradosService calculadora) {
        this.calculadora = calculadora;
    }

    @PostMapping("/casa/metros")
    public ResponseEntity<CalculadoraResponse> calcularMetrosQuadrados(@RequestBody Casa casa) {
        return ResponseEntity.ok(calculadora.calcular(casa));
    }
}
