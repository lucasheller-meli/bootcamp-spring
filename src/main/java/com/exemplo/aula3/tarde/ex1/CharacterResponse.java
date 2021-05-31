package com.exemplo.aula3.tarde.ex1;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CharacterResponse {

    private List<CharactersStarWars> charactersStarWars;


}
