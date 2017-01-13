package com.example.hannes.beergame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class customizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);
        initiateButtons();
    }
    private void initiateButtons() {


        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            EditText text = (EditText) findViewById(R.id.editText3);
            String leknamn = text.getText().toString();

        if(TextUtils.isEmpty(leknamn)) {
            text.setError("Your message");
            return;


                }else {
                Intent intent = new Intent(customizeActivity.this, CreateDeckActivity.class);
                startActivity(intent);
            }
                        }});
}}



