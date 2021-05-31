package com.exemplo.aula3.tarde.ex1;

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

    public List<CharactersStarWars> findByName(String name){
        List<CharactersStarWars> charactersStarWars = localDatabase();
        return charactersStarWars.stream()
                .filter(character -> character.getName().contains(name)).collect(Collectors.toList());
    }

    public List<CharactersStarWars> localDatabase(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<CharactersStarWars>> type = new TypeReference<>() {};
        List<CharactersStarWars> charactersStarWars = null;
        try {
            charactersStarWars = mapper.readValue(file, type);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return charactersStarWars;
    }

}
