package com.example.hannes.beergame.logic;

import android.content.Context;

import com.example.hannes.beergame.Storage.StorageProvider;
import com.example.hannes.beergame.common.CardDeck;

import java.util.List;

/**
 * Created by Hannes on 2016-12-05.
 */

public class CardDeckLogic {
    private Context c;

    public CardDeckLogic(Context c) {
        this.c = c;
    }

    public List<CardDeck> getCardDecks() {
        return StorageProvider.getCardDeckStore(c).getCardDeck();
    }

    public void addCardDeck(CardDeck m) {
        StorageProvider.getCardDeckStore(c).addCardDeck(m);
    }
}
