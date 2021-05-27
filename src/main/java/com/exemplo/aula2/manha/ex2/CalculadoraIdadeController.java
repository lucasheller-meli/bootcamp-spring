package com.exemplo.aula2.manha.ex2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController("/data")
public class CalculadoraIdadeController {

    private final CalculaIdade calculaIdade;

    public CalculadoraIdadeController(CalculaIdade calculaIdade) {
        this.calculaIdade = calculaIdade;
    }

    @GetMapping("/{dia}/{mes}/{ano}")
    public ResponseEntity <Integer> calcularIdade(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer ano){
        LocalDate data = LocalDate.of(ano, mes, dia);
        return ResponseEntity.ok(calculaIdade.idade(data));
    }

}
