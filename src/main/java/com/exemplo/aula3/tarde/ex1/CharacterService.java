package com.exemplo.aula3.tarde.ex1;


import org.springframework.stereotype.Service;



@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public CharacterResponse procurarPersonagem(Personagem personagem) {
       var characters = characterRepository.findByName(personagem.getName());

        return CharacterResponse.builder()
                .characters(characters)
                .build();
    }
}
