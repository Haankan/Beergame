package com.example.hannes.beergame.Storage;

import com.example.hannes.beergame.common.CardDeck;

import java.util.List;

/**
 * Created by Hannes on 2016-12-14.
 */

public interface InstructionsStore {
    public List<Instructions> getInstructions();
    public void addInstrutions(Instructions m);
}
