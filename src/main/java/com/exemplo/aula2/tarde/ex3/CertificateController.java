package com.exemplo.aula2.tarde.ex3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class CertificateController {

    private final CertificateService service;

    public CertificateController(CertificateService service) {
        this.service = service;
    }

    @GetMapping("/certificate")
    public ResponseEntity<Certificate> gerarDiploma(@RequestBody Student student) {
        return ResponseEntity.ok(service.generateCertificate(student));
    }
}
