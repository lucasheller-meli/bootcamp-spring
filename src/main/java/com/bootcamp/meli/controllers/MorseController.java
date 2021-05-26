package com.bootcamp.meli.controllers;

import com.bootcamp.meli.services.CodigoMorse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    private final CodigoMorse codigoMorse;

    public MorseController(CodigoMorse codigoMorse) {
        this.codigoMorse = codigoMorse;
    }

    @GetMapping(value = "/morse/{codigo}")
    public ResponseEntity<String> numeroRomano(@PathVariable final String codigo){
        return ResponseEntity.ok(codigoMorse.traduzirMorse(codigo));
    }
}
