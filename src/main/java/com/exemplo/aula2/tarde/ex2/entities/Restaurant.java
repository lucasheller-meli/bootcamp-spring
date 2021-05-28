package com.exemplo.aula2.tarde.ex2.entities;

public class Restaurant {
    private static Double cash = 0D;

    public static Double getCash() {
        return cash;
    }

    public static void addCash(Double cash) {
        Restaurant.cash += cash;
    }
}
