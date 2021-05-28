package com.exemplo.aula3.tarde.ex1;

import com.exemplo.aula3.manha.ex1.Ingredient;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CharacterResponse {
    private List<Character> characters;

}
