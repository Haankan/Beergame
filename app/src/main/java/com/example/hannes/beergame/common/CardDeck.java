package com.example.hannes.beergame.common;

/**
 * Created by Hannes on 2016-12-05.
 */

public class CardDeck {
    private String name;
    private String email;

    public CardDeck(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + "<"+email+">";
    }

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }

}
