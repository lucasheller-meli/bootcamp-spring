package com.exemplo.aula2.tarde.ex1;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Degree {
    private Student student;
    private Double average;
    private String message;
}
