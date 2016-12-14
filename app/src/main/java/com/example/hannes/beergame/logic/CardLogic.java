package com.example.hannes.beergame.logic;

import android.content.Context;

import com.example.hannes.beergame.Storage.StorageProvider;
import com.example.hannes.beergame.common.Card;

import java.util.List;

/**
 * Created by Hannes on 2016-12-14.
 */

public class CardLogic {

        private Context c;

        public CardLogic(Context c) {
            this.c = c;
        }

        public List<Card> getInstructions() {
            return StorageProvider.getInstructionsStore(c).getInstructions();
        }

        public void addIntructions(Card m) {
            StorageProvider.getInstructionsStore(c).addInstructions(m);
        }


}
