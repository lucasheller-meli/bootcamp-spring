package com.exemplo.aula2.tarde.ex3;

import lombok.Data;

import java.util.HashMap;

@Data
public class Student {

    private String name;

    private HashMap<String, Integer> grades = new HashMap<>();

}
