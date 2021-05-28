package com.exemplo.aula3.manha.ex1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Food {
    private String name;
    private List<String> ingredientNames;
}
