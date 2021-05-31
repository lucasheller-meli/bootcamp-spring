package com.exemplo.aula3.tarde.ex1;

import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    public CharacterResponse findCharacter(Person person){
        var characters = characterRepository.findByName(person.getName());

        return CharacterResponse.builder()
                .charactersStarWars(characters)
                .build();

    }
}
