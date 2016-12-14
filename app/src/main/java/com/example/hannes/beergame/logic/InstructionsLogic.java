package com.example.hannes.beergame.logic;

import android.content.Context;

import com.example.hannes.beergame.Storage.StorageProvider;
import com.example.hannes.beergame.common.CardDeck;

import java.util.List;

/**
 * Created by Hannes on 2016-12-14.
 */

public class InstructionsLogic {

        private Context c;

        public InstructionsLogic(Context c) {
            this.c = c;
        }

        public List<Instructions> getInstructions() {
            return StorageProvider.getInstructionsStore(c).getInstructions();
        }

        public void addIntructions(Instructions m) {
            StorageProvider.getInstructionsStore(c).addInstructions(m);
        }


}
