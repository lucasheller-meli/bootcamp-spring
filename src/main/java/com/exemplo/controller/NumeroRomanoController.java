package com.exemplo.controller;

import com.exemplo.model.Pessoa;
import com.exemplo.services.NumeroRomanoService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class NumeroRomanoController {

    private final NumeroRomanoService numeroRomanoService;
    private final Pessoa[] pessoas = new Pessoa[5];
    private int index = 0;

    public NumeroRomanoController(NumeroRomanoService numeroRomanoService) {
        this.numeroRomanoService = numeroRomanoService;
    }

    @GetMapping( "/romano/{numeroRomano}")
    public ResponseEntity<String> numeroRomano(@PathVariable final Integer numeroRomano){
        return ResponseEntity.ok(numeroRomanoService.converterRomanos(numeroRomano));
    }

    @PostMapping("/pessoa")
    public ResponseEntity<Pessoa[]> adicionarPessoa(@RequestBody Pessoa pessoa){
        if(index >= pessoas.length){
            return ResponseEntity.badRequest().build();
        }
        pessoas[index] = pessoa;
        index++;
        return ResponseEntity.ok(pessoas);
    }

}