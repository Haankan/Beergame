package com.example.hannes.beergame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hannes.beergame.Storage.MySQLiteHelper;

import java.util.List;

public class choosedeckActivity extends AppCompatActivity implements
        OnItemSelectedListener {

    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosedeck);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener((OnItemSelectedListener) this);
        loadSpinnerData();
    }
    private void loadSpinnerData() {
        // database handler
        MySQLiteHelper db = new MySQLiteHelper(getApplicationContext());

        // Spinner Drop down elements
        List<String> decks = db.getAllDecks();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, decks);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        // On selecting a spinner item
        String label = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Du valde kortleken: " + label,
                Toast.LENGTH_LONG).show();

    }




    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

