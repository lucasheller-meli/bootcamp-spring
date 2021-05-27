package com.bootcamp.meli.controllers;

import com.bootcamp.meli.controllers.response.CasaResponse;
import com.bootcamp.meli.entities.Casa;
import com.bootcamp.meli.services.CasaService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/casa")
public class CasaController {

    private final CasaService casaService;

    public CasaController(CasaService casaService) {
        this.casaService = casaService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CasaResponse> calcularCasa(@RequestBody Casa casa) {
        return ResponseEntity.ok(casaService.verificarCasa(casa));
    }


}
