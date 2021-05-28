package com.exemplo.aula3.manha.ex1;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class CaloriesCalculatorService {
    private final IngredientRepository ingredientRepository;

    public CaloriesCalculatorService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public CaloriesCalculatorResponse calculateCalories(Food food) {
        var ingredients = food.getIngredientNames().stream().map(ingredientRepository::findByName).collect(Collectors.toList());
        var totalCalories = ingredients.stream().mapToInt(Ingredient::getCalories).sum();
        var ingredientWithMostCalories = ingredients.stream().max(Comparator.comparing(Ingredient::getCalories));

        return CaloriesCalculatorResponse.builder()
                .totalCalories(totalCalories)
                .ingredients(ingredients)
                .ingredientWithMostCalories(ingredientWithMostCalories.get())
                .build();
    }
}
