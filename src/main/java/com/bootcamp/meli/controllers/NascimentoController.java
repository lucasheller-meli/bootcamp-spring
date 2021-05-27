package com.bootcamp.meli.controllers;

import com.bootcamp.meli.services.NascimentoService;
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
    public ResponseEntity<Integer> verificaIdade(@PathVariable final Integer dia, @PathVariable final Integer mes, @PathVariable final Integer ano) {

        return ResponseEntity.ok(nascimentoService.calculaIdade(LocalDate.of(ano, mes, dia)));
    }
}
