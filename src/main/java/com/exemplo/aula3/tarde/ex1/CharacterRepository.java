package com.exemplo.aula3.tarde.ex1;

import com.exemplo.aula3.tarde.ex1.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository {

    public List<Character> findByName(String name) {
        List<Character> characters = loadDatabase();
        return characters.stream().filter(character -> character.getName().contains(name)).collect(Collectors.toList());
    }

    private List<Character> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Character>> type = new TypeReference<>() {};
        List<Character> characters = null;
        try {
            characters = mapper.readValue(file, type);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return characters;
    }
}
