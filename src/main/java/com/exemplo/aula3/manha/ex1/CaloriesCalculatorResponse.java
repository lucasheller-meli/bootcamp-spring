package com.exemplo.aula3.manha.ex1;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CaloriesCalculatorResponse {
    private Integer totalCalories;
    private List<Ingredient> ingredients;
    private Ingredient ingredientWithMostCalories;
}
