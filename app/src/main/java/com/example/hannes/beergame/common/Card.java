package com.example.hannes.beergame.common;

/**
 * Created by v on 2016-12-14.
 */

public class Card {

    private int CardDeckId;
    private int CardId;
    private String instruction;

    public Card(int CardDeckId, int CardId, String instruction){
        this.CardDeckId = CardDeckId;
        this.CardId = CardId;
        this.instruction = instruction;
    }

    @Override
    public String toString() {
        return instruction;
    }

    public String instruction() {
        return instruction;
    }
    public int CardDeckId() { return CardDeckId;}
    public int CardId() { return CardId;}
}
