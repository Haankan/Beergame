package com.example.hannes.beergame;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hannes.beergame.logic.CardRandomizer;

import java.util.ArrayList;
import java.util.Random;

public class playActivity extends AppCompatActivity {

  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    } */

    CardRandomizer cardRandomizer = new CardRandomizer();
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Button changeview = (Button) findViewById(R.id.button4);
        final ImageView imgView = (ImageView) findViewById(R.id.card);
        changeview.setOnClickListener(new View.OnClickListener() {
            //Set variables
            int id;
            //Create arraylist
            ArrayList<Integer> cardList = new ArrayList<Integer>();
            //Get counter textview
            TextView Counter =(TextView) findViewById(R.id.counter);

            @Override
            //Action to perform on click
            public void onClick(View v) {
                Counter.setText("New Game");
                Random rand = new Random();
                //if the list is empty set it to getIds
                if(cardList.size()== 0){
                    id = getResources().getIdentifier("com.example.hannes.beergame:drawable/" + "kortrygg_tbg", null, null);
                    cardList = cardRandomizer.getIDs(context);
                    Log.e("!","New Deck");
                }
                //else pick a random card, display it on the image view and remove it from the array
                else{
                    int r = rand.nextInt(cardList.size());
                    id = cardList.get(r);
                    String name = getResources().getResourceEntryName(id);
                    Log.e("name",""+name);
                    Log.e("Array", "" + cardList);
                    cardList.remove(r);
                    Counter.setText(Integer.toString(cardList.size()));
                }

                imgView.setImageResource(id);
            }
        });
    }


    public void imageClick(View view) {
    }
}
