package com.exemplo.aula3.manha.ex1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredientRepository {
    public Ingredient findByName(String name) {
        List<Ingredient> ingredients = loadDatabase();
        return ingredients.stream().filter(ingredient -> name.equals(ingredient.getName())).findFirst().get();
    }

    private List<Ingredient> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Ingredient>> type = new TypeReference<>() {};
        List<Ingredient> ingredients = null;
        try {
            ingredients = mapper.readValue(file, type);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ingredients;
    }
}
