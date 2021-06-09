package com.exemplo.aula2.tarde.ex1;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
public class Student {

    @Size(min = 8, max = 50, message = "Numero de caracter nao compativel.")
    @Pattern(regexp = "[A-z]*", message = "Deve conter somente letra A-Z.")
    private String name;
    @Valid
    private List<Subject> subjects;
}
