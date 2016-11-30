package com.example.hannes.beergame.Storage;

/**
 * Created by v on 2016-11-30.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_CARDS = "cards";
    public static final String CARDS_COLUMN_ID     = "_id";
    public static final String CARDS_COLUMN_TYPE   = "type";
    public static final String CARDS_COLUMN_NUMBER  = "number";

    public static final String TABLE_CARDDECKS = "carddecks";
    public static final String DECKS_COLUMN_ID     = "_id";
    public static final String DECKS_COLUMN_NAME   = "name";

    public static final String TABLE_GAMEINSTRUCTIONS = "gameinstructions";
    public static final String INSTR_COLUMN_CARDDECKSID     = "decksid";
    public static final String INSTR_COLUMN_CARDSID     = "cardsid";
    public static final String INSTR_COLUMN_INSTRUCTIONS   = "instructions";

    private static final String DATABASE_NAME = "cards.db";
    private static final int DATABASE_VERSION = 1;

    private static final String LOG_TAG = MySQLiteHelper.class.getName();

    // Database creation sql statement
    private static final String CARDS_DATABASE_CREATE = "create table "
            + TABLE_CARDS + "( "
            + CARDS_COLUMN_ID     + " integer primary key autoincrement, "
            + CARDS_COLUMN_TYPE   +  " text not null,"
            + CARDS_COLUMN_NUMBER  +  " text not null);";


     private static final String DECKS_DATABASE_CREATE = "create table "
            + TABLE_CARDDECKS + "( "
            + DECKS_COLUMN_ID     + " integer primary key autoincrement, "
            + DECKS_COLUMN_NAME  +  " text not null);";

     private static final String GAMEINSTRUCTIONS_DATABASE_CREATE = "create table "
            + TABLE_GAMEINSTRUCTIONS + "( "
            + INSTR_COLUMN_CARDDECKSID     + " integer primary key autoincrement, "
            + INSTR_COLUMN_CARDSID    + " integer primary key autoincrement, "
            + INSTR_COLUMN_INSTRUCTIONS  +  " text not null);";



    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CARDS_DATABASE_CREATE);
        database.execSQL(DECKS_DATABASE_CREATE);
        database.execSQL(GAMEINSTRUCTIONS_DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.d(LOG_TAG, " can't upgrade");
    }

}

