package com.exemplo.aula2.manha.ex2;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class CalculaIdade {

    public Integer idade(LocalDate dataNascimento){
        LocalDate dataHoje = LocalDate.now();
        Period diff = Period.between(dataNascimento, dataHoje);
        return diff.getYears();
    }

}
