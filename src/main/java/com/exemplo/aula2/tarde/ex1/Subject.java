package com.exemplo.aula2.tarde.ex1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
public class Subject {

    @Size(min = 8, max = 50, message = "Numero de caracter nao compativel.")
    @Pattern(regexp = "[A-z]*", message = "Deve conter somente letra A-Z.")
    private String name;
    @DecimalMax(value = "10", message = "Nota maxima 10.")
    @DecimalMin(value = "0", message = "Nota minima 0.")
    private Double grade;
}
