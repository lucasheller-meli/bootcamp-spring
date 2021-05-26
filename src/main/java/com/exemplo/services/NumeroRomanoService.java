package com.exemplo.services;

import org.springframework.stereotype.Service;



@Service
public class NumeroRomanoService {

    private static final int[] DECIMAIS =
            {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMANOS =
            {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String converterRomanos(int decimal){
        final StringBuilder result = new StringBuilder();
        for (int i = 0; decimal > 0; i++){
            if(decimal >= DECIMAIS[i]){
                result.append(ROMANOS[i]);
                decimal -= DECIMAIS[i];
                i--;
            }
        }
        return result.toString();
    }

}