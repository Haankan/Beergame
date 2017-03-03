package com.example.hannes.beergame.logic;

import android.content.Context;

import com.example.hannes.beergame.Storage.StorageProvider;
import com.example.hannes.beergame.common.Card;

import java.util.List;

/**
 * Created by Hannes on 2016-12-14.
 * Logiklager för kort
 */

public class CardLogic {

        private Context c;

        public CardLogic(Context c) {
            this.c = c;
        }

        public List<Card> getCard() {
            return StorageProvider.getCardStore(c).getCard();
        }

        public void addIntructions(Card m) {
            StorageProvider.getCardStore(c).addCard(m);
        }


}
