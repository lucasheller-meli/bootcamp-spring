package com.exemplo.aula2.tarde.ex1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private List<Subject> subjects;
}
