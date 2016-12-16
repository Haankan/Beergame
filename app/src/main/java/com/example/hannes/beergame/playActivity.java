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

import java.util.List;
import java.util.Random;

public class playActivity extends AppCompatActivity {

  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    } */

    private static Card       currentCard ;
    private static List<Card> currentCards ;


    CardRandomizer cardRandomizer = new CardRandomizer();
    Context context = this;
    private CardLogic cl  = new CardLogic(this);


    int[] myImageList = new int[]{R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6, R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10, R.drawable.h11, R.drawable.h12, R.drawable.h13,
            R.drawable.s14,R.drawable.s15,R.drawable.s16,R.drawable.s17,R.drawable.s18,R.drawable.s19,R.drawable.s20,R.drawable.s21,R.drawable.s22,R.drawable.s23,R.drawable.s24,R.drawable.s25,R.drawable.s26,
            R.drawable.r27,R.drawable.r28,R.drawable.r29,R.drawable.r30,R.drawable.r31,R.drawable.r32,R.drawable.r33,R.drawable.r34,R.drawable.r35,R.drawable.r36,R.drawable.r37,R.drawable.r38,R.drawable.r39,
            R.drawable.k40,R.drawable.k41,R.drawable.k42,R.drawable.k43,R.drawable.k44,R.drawable.k45,R.drawable.k46,R.drawable.k47,R.drawable.k48,R.drawable.k49,R.drawable.k50,R.drawable.k51,R.drawable.k52};

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
//            ArrayList<Integer> cardList = new ArrayList<Integer>();
            //Get counter textview
            TextView Counter =(TextView) findViewById(R.id.counter);

            @Override
            //Action to perform on click
            public void onClick(View v) {

                Counter.setText("New Game");
                Random rand = new Random();
                //if the list is empty set it to getIds

                if(currentCards == null || currentCards.size() ==0){
                 //  id = getResources().getIdentifier("com.example.hannes.beergame:drawable/" + "kortrygg_tbg", null, null);
                     // cardList = cardRandomizer.getIDs(context);
                    Log.e("!","New Deck");
                    currentCards = cl.getCard();

                }
                //else pick a random card, display it on the image view and remove it from the array
                else{

                    Log.e("Array", "" + cl.getCard().size());
                    Log.e("Array", "" );
                    //currentCards = cl.getCard();
                    int r  = rand.nextInt(currentCards.size());

                    Log.e("Array", "" + cl.getCard().size());
                    currentCard = currentCards.get(r);
                    // String name = getResources().getResourceEntryName(id);
                    //Log.e("name",""+name);
                    Log.e("Array", "" + currentCards);
                    Log.d("pA", "  id:    " +    currentCard.CardId());
                    currentCards.remove(r);

                   // Counter.setText(Integer.toString(currentCards.size()));
                    Counter.setText(currentCard.instruction());

                    Log.d("pA", "  id:    " +    currentCard.CardId());
                    Log.d("pA", "  cards: " + currentCards.size());
                    Log.d("pA", "  card:  " +    currentCard);
                    Log.d("pA", "  id:    " +    currentCard.CardId());
                    Log.d("pA", "  ins:    " +    currentCard.instruction());
                    Log.d("pA", "  cardDeck:    " +    currentCard.CardDeckId());
                    imgView.setImageResource(myImageList[r]);
                }


                Log.d("pA", "  cards: " + currentCards.size());
                Log.d("pA", "  card:  " +    currentCard);
//                Log.d("pA", "  id:    " +    currentCard.CardId());
  //              Log.d("pA", "  ins:    " +    currentCard.instruction());
    //            Log.d("pA", "  carddeck:    " +    currentCard.CardDeckId());
               // imgView.setImageResource(myImageList(r));
            }
        });
    }


    public void imageClick(View view) {
    }
}
