package com.exemplo.aula2.tarde.ex3;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.OptionalDouble;

@Service
public class CertificateService {

    public Certificate generateCertificate(Student student) {
        HashMap<String, Integer> grades = student.getGrades();
        OptionalDouble avarege = grades.values().stream().mapToDouble(Integer::doubleValue).average();
        double md = avarege.orElse(0.0);
        if(md > 9.0) {
            return new Certificate(student.getName(), md,"Parabéns, você é nerd!");
        } else if(md > 6.5) {
            return new Certificate(student.getName(), md,"Você foi aprovado.");
        } else {
            return new Certificate(student.getName(), md,"Reprovado.");
        }
    }
}
