package com.exemplo.aula3.tarde.ex1;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping("/personagens")
    public ResponseEntity<CharacterResponse> procurarPersonagem(@RequestBody Personagem personagem) {
        return ResponseEntity.ok(characterService.procurarPersonagem(personagem));
    }
}
