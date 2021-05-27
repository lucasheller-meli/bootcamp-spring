package com.bootcamp.meli.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class NascimentoService {

    public String calculaIdade(LocalDate nascimento) {
        final LocalDate agora = LocalDate.now();
        final Period diff = Period.between(agora, nascimento);
        return String.valueOf(diff.getYears());
    }
}
