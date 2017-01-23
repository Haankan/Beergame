package com.example.hannes.beergame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class CreateDeeckActivity extends AppCompatActivity {
    private ArrayList<Integer> myImageList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_deeck);
        final ImageView imgView = (ImageView) findViewById(R.id.kortvy);

        myImageList.add(R.drawable.h1);
        myImageList.add(R.drawable.h2);
        myImageList.add(R.drawable.h3);
        myImageList.add(R.drawable.h4);
        myImageList.add(R.drawable.h5);
        myImageList.add(R.drawable.h6);
        myImageList.add(R.drawable.h7);
        myImageList.add(R.drawable.h8);
        myImageList.add(R.drawable.h9);
        myImageList.add(R.drawable.h10);
        myImageList.add(R.drawable.h11);
        myImageList.add(R.drawable.h12);
        myImageList.add(R.drawable.h13);
        myImageList.add(R.drawable.s14);
        myImageList.add(R.drawable.s15);
        myImageList.add(R.drawable.s16);
        myImageList.add(R.drawable.s17);
        myImageList.add(R.drawable.s18);
        myImageList.add(R.drawable.s19);
        myImageList.add(R.drawable.s20);
        myImageList.add(R.drawable.s21);
        myImageList.add(R.drawable.s22);
        myImageList.add(R.drawable.s23);
        myImageList.add(R.drawable.s24);
        myImageList.add(R.drawable.s25);
        myImageList.add(R.drawable.s26);
        myImageList.add(R.drawable.r27);
        myImageList.add(R.drawable.r28);
        myImageList.add(R.drawable.r29);
        myImageList.add(R.drawable.r30);
        myImageList.add(R.drawable.r31);
        myImageList.add(R.drawable.r32);
        myImageList.add(R.drawable.r33);
        myImageList.add(R.drawable.r34);
        myImageList.add(R.drawable.r35);
        myImageList.add(R.drawable.r36);
        myImageList.add(R.drawable.r37);
        myImageList.add(R.drawable.r38);
        myImageList.add(R.drawable.r39);
        myImageList.add(R.drawable.k40);
        myImageList.add(R.drawable.k41);
        myImageList.add(R.drawable.k42);
        myImageList.add(R.drawable.k43);
        myImageList.add(R.drawable.k44);
        myImageList.add(R.drawable.k45);
        myImageList.add(R.drawable.k46);
        myImageList.add(R.drawable.k47);
        myImageList.add(R.drawable.k48);
        myImageList.add(R.drawable.k49);
        myImageList.add(R.drawable.k50);
        myImageList.add(R.drawable.k51);
        myImageList.add(R.drawable.k52);
        Button changeview = (Button) findViewById(R.id.button7);

        changeview.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                              imgView.setImageResource(myImageList.get(1));
                                              myImageList.remove(1);
                                              ((EditText) findViewById(R.id.editText)).setText("");
                                          }


                                      }

        );


    }}