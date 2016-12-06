package com.example.hannes.beergame.logic;

import android.content.Context;

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
        return null;// StorageProvider.getMemberStore(c).getMembers();
    }

    public void addMember(CardDeck m) {
        //StorageProvider.getMemberStore(c).addMember(m);
    }
}
