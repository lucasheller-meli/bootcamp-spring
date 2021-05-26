package com.exemplo.controller;

import com.exemplo.services.CodigoMorse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MorseController {

    private final CodigoMorse codigoMorse;

    public MorseController(CodigoMorse codigoMorse) {
        this.codigoMorse = codigoMorse;
    }

    @GetMapping(value = "/morse/{codigo}")
    public ResponseEntity<String> morsePortugues(@PathVariable final String codigo){
        return ResponseEntity.ok(codigoMorse.traduzirMorse(codigo));
    }

    @GetMapping(value = "/morse/portugues/{frase}")
    public ResponseEntity<String> portuguesMorse(@PathVariable final String frase){
        return ResponseEntity.ok(codigoMorse.traduzirPortugues(frase));
    }

}
