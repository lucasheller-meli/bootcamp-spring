package com.exemplo.controller;

import com.exemplo.services.NumeroRomanoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeroRomanoController {

    private final NumeroRomanoService numeroRomanoService;

    public NumeroRomanoController(NumeroRomanoService numeroRomanoService) {
        this.numeroRomanoService = numeroRomanoService;
    }

    @GetMapping(value = "/romano/{numeroRomano}")
    public ResponseEntity<String> numeroRomano(@PathVariable final Integer numeroRomano){
        return ResponseEntity.ok(numeroRomanoService.converterRomanos(numeroRomano));
    }

}