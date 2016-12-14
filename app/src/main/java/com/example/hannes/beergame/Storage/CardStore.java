package com.example.hannes.beergame.Storage;

import com.example.hannes.beergame.common.Card;

import java.util.List;

/**
 * Created by Hannes on 2016-12-14.
 */

public interface CardStore {
    public List<Card> getCard();
    public void addCard(Card m);
}
