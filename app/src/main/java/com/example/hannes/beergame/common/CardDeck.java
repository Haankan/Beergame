package com.example.hannes.beergame.common;

/**
 * Created by Hannes on 2016-12-05.
 * CardDeck class för att hämta CardDecks
 * Nödvändig vid val av CardDeck till spel
 */

public class CardDeck {
    private String name;
   // private String instructions;


    public CardDeck(String name) {
        this.name = name;
      //  this.name = instructions;

    }

    @Override
    public String toString() {
        return name;
    }

    public String name() {return name;}

   // public String instructions() {return instructions;}






}
