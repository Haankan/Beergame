package com.example.hannes.beergame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hannes.beergame.common.CardDeck;
import com.example.hannes.beergame.logic.CardDeckLogic;

public class instructionsActivity extends AppCompatActivity {
    private ListView CardDeckList;
    private ArrayAdapter<CardDeck> adapter;
    private CardDeckLogic cl;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        cl = new CardDeckLogic(this);

        CardDeckList = (ListView) findViewById(R.id.carddeck_list);
        adapter = new ArrayAdapter<CardDeck>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                cl.getCardDecks());
        CardDeckList.setAdapter(adapter);
    }


}
