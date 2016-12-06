package com.example.hannes.beergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hannes.beergame.common.CardDeck;
import com.example.hannes.beergame.logic.CardDeckLogic;

public class instructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        CardDeckLogic model = new CardDeckLogic();
            for (CardDeck m; model.getCardDecks()){
                System.out.println("m: " + m);

            }
    }
}
