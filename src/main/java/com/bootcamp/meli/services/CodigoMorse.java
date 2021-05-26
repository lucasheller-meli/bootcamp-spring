package com.bootcamp.meli.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CodigoMorse {

    private static final Map<String, String> morse = new HashMap<>();
    static {
        morse.put(".-", "a");
        morse.put("-...", "b");
        morse.put("-.-.", "c");
        morse.put("-..", "d");
        morse.put(".", "e");
        morse.put("..-.", "f");
        morse.put("--.", "g");
        morse.put("....", "h");
        morse.put("..", "i");
        morse.put(".---", "j");
        morse.put("-.-", "k");
        morse.put(".-..", "l");
        morse.put("--", "m");
        morse.put("-.", "n");
        morse.put("---", "o");
        morse.put(".--.", "p");
        morse.put("--.-", "q");
        morse.put(".-.", "r");
        morse.put("...", "s");
        morse.put("-", "t");
        morse.put("..-", "u");
        morse.put("...-", "v");
        morse.put(".--", "w");
        morse.put("-..-", "x");
        morse.put("-.--", "y");
        morse.put("--..", "z");
    }


    public String traduzirMorse(String codigo) {
        final StringBuilder frase = new StringBuilder();
        final String[] palavras = codigo.split("   ");
        for (String palavra : palavras) {
            String[] letras = palavra.split(" ");

            for (String letra : letras) {
                frase.append(morse.get(letra));
            }
            frase.append(" ");
        }


        return frase.toString();
    }
}
