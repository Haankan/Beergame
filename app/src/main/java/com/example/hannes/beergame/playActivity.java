package com.example.hannes.beergame;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hannes.beergame.common.Card;
import com.example.hannes.beergame.logic.CardLogic;
import com.example.hannes.beergame.logic.CardRandomizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.hannes.beergame.R.*;

/**
 * Här är det tänkt att man ska spela
 * Alltså en Klass för spelande
 */

public class playActivity extends AppCompatActivity {

  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    } */

    private  Card       currentCard ;
    private  List<Card> currentCards ;
    private  ArrayList<Integer> myImageList = new ArrayList<>();

    CardRandomizer cardRandomizer = new CardRandomizer();
    Context context = this;
    private CardLogic cl  = new CardLogic(this);
   //int[] myImageList = new int[];
    //ArrayList<Integer> myImageList = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_play);
        Button changeview = (Button) findViewById(id.button4);
        final ImageView imgView = (ImageView) findViewById(id.card);
        changeview.setOnClickListener(new View.OnClickListener() {
            //Set variables
            int id;
            //Create arraylist
//            ArrayList<Integer> cardList = new ArrayList<Integer>();
            //Get counter textview
            TextView Counter =(TextView) findViewById(R.id.counter);

            @Override

            public void onClick(View v) {

                Counter.setText("New Game");
                Random rand = new Random();


                if(currentCards == null || currentCards.size() ==0){
                    imgView.setImageResource(getResources().getIdentifier("com.example.hannes.beergame:drawable/" + "kortrygg_tbg", null, null));

                    Log.e("!","New Deck");
                    currentCards = cl.getCard();
                    myImageList.add(R.drawable.h1);
                    myImageList.add(R.drawable.h2);
                    myImageList.add(drawable.h3);
                    myImageList.add(drawable.h4);
                    myImageList.add(drawable.h5);
                    myImageList.add(drawable.h6);
                    myImageList.add(drawable.h7);
                    myImageList.add(drawable.h8);
                    myImageList.add(drawable.h9);
                    myImageList.add(drawable.h10);
                    myImageList.add(drawable.h11);
                    myImageList.add(drawable.h12);
                    myImageList.add(drawable.h13);
                    myImageList.add(drawable.s14);
                    myImageList.add(drawable.s15);
                    myImageList.add(drawable.s16);
                    myImageList.add(drawable.s17);
                    myImageList.add(drawable.s18);
                    myImageList.add(drawable.s19);
                    myImageList.add(drawable.s20);
                    myImageList.add(drawable.s21);
                    myImageList.add(drawable.s22);
                    myImageList.add(drawable.s23);
                    myImageList.add(drawable.s24);
                    myImageList.add(drawable.s25);
                    myImageList.add(drawable.s26);
                    myImageList.add(drawable.r27);
                    myImageList.add(drawable.r28);
                    myImageList.add(drawable.r29);
                    myImageList.add(drawable.r30);
                    myImageList.add(drawable.r31);
                    myImageList.add(drawable.r32);
                    myImageList.add(drawable.r33);
                    myImageList.add(drawable.r34);
                    myImageList.add(drawable.r35);
                    myImageList.add(drawable.r36);
                    myImageList.add(drawable.r37);
                    myImageList.add(drawable.r38);
                    myImageList.add(drawable.r39);
                    myImageList.add(drawable.k40);
                    myImageList.add(drawable.k41);
                    myImageList.add(drawable.k42);
                    myImageList.add(drawable.k43);
                    myImageList.add(drawable.k44);
                    myImageList.add(drawable.k45);
                    myImageList.add(drawable.k46);
                    myImageList.add(drawable.k47);
                    myImageList.add(drawable.k48);
                    myImageList.add(drawable.k49);
                    myImageList.add(drawable.k50);
                    myImageList.add(drawable.k51);
                    myImageList.add(drawable.k52);

                }
                //else pick a random card, display it on the image view and remove it from the array
                else{

                    Log.e("Array", "" + cl.getCard().size());
                    Log.e("Array", "" );
                    //currentCards = cl.getCard();
                    int r  = rand.nextInt(currentCards.size());

                    Log.e("Array", "" + cl.getCard().size());
                    currentCard = currentCards.get(r);

                    Log.e("Array", "" + currentCards);
                    Log.d("pA", "  id:    " +    currentCard.CardId());
                    currentCards.remove(r);

                    Counter.setText(currentCard.instruction());

                    Log.d("pA", "  id:    " +    currentCard.CardId());
                    Log.d("pA", "  cards: " + currentCards.size());
                    Log.d("pA", "  card:  " +    currentCard);
                    Log.d("pA", "  id:    " +    currentCard.CardId());
                    Log.d("pA", "  ins:    " +    currentCard.instruction());
                    Log.d("pA", "  cardDeck:    " +    currentCard.CardDeckId());
                    imgView.setImageResource(myImageList.get(r));
                    myImageList.remove(r);
                }


                Log.d("pA", "  cards: " + currentCards.size());
                Log.d("pA", "  card:  " +    currentCard);

            }
        });
    }


    public void imageClick(View view) {
    }
}
