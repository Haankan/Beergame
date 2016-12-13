package com.example.hannes.beergame.logic;

import android.content.Context;

import com.example.hannes.beergame.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
/**
 * Created by v on 2016-12-13.
 */
// Code for CardRandomizer class from
// https://github.com/DennisdeBest/AndroidAppBarbu/blob/master/app/src/main/java/com/example/dennis/cards/CardRandomizer.java

public class CardRandomizer {

    public ArrayList<Integer> getIDs(Context context){

        ArrayList<Integer> res = new ArrayList<>();
        final R.drawable drawableResources = new R.drawable();
        final Class<R.drawable> c = R.drawable.class;
        final Field[] fields = c.getDeclaredFields();

        for (int i = 0, max = fields.length; i < max; i++) {
            final int resourceId;
            try {
                resourceId = fields[i].getInt(drawableResources);
                String name = context.getResources().getResourceEntryName(resourceId);
                //Use regex to filter out system ressources
                if (name.matches("(clubs|spades|diamonds|hearts).*"))
                    res.add(resourceId);
            } catch (Exception e) {
                continue;
            }
        }
        //return the resulting array
        return res;
    }
}
