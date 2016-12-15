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
                        id = getResources().getIdentifier("com.example.hannes.beergame:drawable/" + "kortrygg_tbg", null, null);
                        //   cardList = cardRandomizer.getIDs(context);
                        Log.e("!","New Deck");
                        currentCards = cl.getCard();

                }
                //else pick a random card, display it on the image view and remove it from the array
                else{

                    Log.e("Array", "" + cl.getCard().size());

                    //currentCards = cl.getCard();
                    int r  = rand.nextInt(cl.getCard().size());
                        Log.e("Arraya", "" + r );
                    Log.e("Arrayaa", "" + cl.getCard().size());
                    currentCard = currentCards.get(r);
                    // String name = getResources().getResourceEntryName(id);
                    //Log.e("name",""+name);
                    Log.e("Array", "" + currentCards);
                    Log.d("pA", "  id:    " +    currentCard.CardId());
                    currentCards.remove(r);
                    Counter.setText(Integer.toString(currentCards.size()));
                    Log.d("pA", "  id:    " +    currentCard.CardId());
                }


                Log.d("pA", "  cards: " + currentCards.size());
                Log.d("pA", "  card:  " +    currentCard);
//               Log.d("pA", "  id:    " +    currentCard.CardId());
//             Log.d("pA", "  ins:    " +    currentCard.instruction());
//              Log.d("pA", "  carddeck:    " +    currentCard.CardDeckId());
//                imgView.setImageResource(id);
            }
        });
    }


    public void imageClick(View view) {
    }
}
