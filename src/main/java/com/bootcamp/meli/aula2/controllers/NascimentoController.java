package com.bootcamp.meli.aula2.controllers;

import com.bootcamp.meli.aula2.services.NascimentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class NascimentoController {

    private final NascimentoService nascimentoService;

    public NascimentoController(NascimentoService nascimentoService) {
        this.nascimentoService = nascimentoService;
    }

    @GetMapping(value = "/{dia}/{mes}/{ano}")
    public ResponseEntity<String> verificaIdade(@PathVariable final Integer dia, @PathVariable final Integer mes, @PathVariable final Integer ano) {

        return ResponseEntity.ok(nascimentoService.calculaIdade(LocalDate.of(ano, mes, dia)));
    }
}
