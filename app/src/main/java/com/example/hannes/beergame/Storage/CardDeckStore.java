package com.example.hannes.beergame.Storage;

import com.example.hannes.beergame.common.CardDeck;

import java.util.List;

/**
 * Created by Hannes on 2016-12-05.
 * Store interface för CardDeck
 */

public interface CardDeckStore {
    public List<CardDeck> getCardDeck();
    public void addCardDeck(CardDeck m);
}
