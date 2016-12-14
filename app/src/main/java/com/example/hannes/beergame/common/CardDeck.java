package com.example.hannes.beergame.common;

/**
 * Created by Hannes on 2016-12-05.
 */

public class CardDeck {
    private String name;


    public CardDeck(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return name;
    }

    public String name() {return name;}




}
