package com.example.hannes.beergame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
/**
 * Klassen där vi väljer kortlek
 *
 */


import com.example.hannes.beergame.Storage.MySQLiteHelper;

import java.util.List;

public class choosedeckActivity extends AppCompatActivity implements
        OnItemSelectedListener {
    public static int spinn;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosedeck);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener((OnItemSelectedListener) this);
        loadSpinnerData();
        initiateButtons();
    }
    private void initiateButtons() {
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(spinn==0){
                    Toast.makeText(getBaseContext(), "Välj kortlek" , Toast.LENGTH_SHORT ).show();
                }else {
                    Intent intent = new Intent(choosedeckActivity.this, playActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void loadSpinnerData() {

        MySQLiteHelper db = new MySQLiteHelper(getApplicationContext());


        List<String> decks = db.getAllinstructions();


          ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, decks);


        spinner.setPrompt("Select an item");
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(dataAdapter);


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {

        String label = parent.getItemAtPosition(position).toString();
        Log.d("pA", "  cardDeck:    " +   position);

        spinn = position;
        if(position== 0){

        }else {
            Toast.makeText(parent.getContext(), "Du valde kortleken: " + label,
                    Toast.LENGTH_LONG).show();
        }

    }




    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

