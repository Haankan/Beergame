package com.example.hannes.beergame.Storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.hannes.beergame.common.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hannes on 2016-12-14.
 */

public class DBCardStore implements CardStore {
    private static DBCardStore storage ;

    private static final String LOG_TAG = DBCardStore.class.getName();

    // Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.INSTR_COLUMN_INSTRUCTIONS,
            MySQLiteHelper.INSTR_COLUMN_CARDDECKSID, MySQLiteHelper.INSTR_COLUMN_CARDSID };

    public DBCardStore(Context context)  {
        dbHelper = new MySQLiteHelper(context);
        try {
            open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Card createCard(Card m) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.INSTR_COLUMN_CARDDECKSID, m.CardDeckId());
        values.put(MySQLiteHelper.INSTR_COLUMN_CARDSID, m.CardId());
        values.put(MySQLiteHelper.INSTR_COLUMN_INSTRUCTIONS, m.instruction());
        //values.put(MySQLiteHelper.COLUMN_EMAIL, m.());

        long insertId = database.insert(MySQLiteHelper.TABLE_GAMEINSTRUCTIONS, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_GAMEINSTRUCTIONS,
                allColumns, MySQLiteHelper.DECKS_COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Card newInstructions = cursorToInstructions(cursor);
        cursor.close();
        Log.d("db" ," storing carddeck");
        return newInstructions;
    }

    private Card cursorToInstructions(Cursor cursor) {
        //long id = cursor.getLong(0)

        int CardDeckId = cursor.getInt(0);
        int CardId = cursor.getInt(1);
        String instruction = cursor.getString(2);
        return new Card(CardDeckId, CardId, instruction);
    }

    public void open() throws SQLException {
        Log.d(LOG_TAG, "opening db");
        Log.d(LOG_TAG, "opening db: " + database);
        database = dbHelper.getWritableDatabase();
        Log.d(LOG_TAG, "opening db: " + database);
    }

    public void close() {
        dbHelper.close();
    }

    @Override
    public List<Card> getCard() {
        List<Card> instructions = new ArrayList<>();

        Log.d(LOG_TAG, "getCardDeck()");
        Log.d(LOG_TAG, "getCardDeck : " + database);
        Log.d(LOG_TAG, "getCardDeck : " + allColumns);

        Cursor cursor = database.query(MySQLiteHelper.TABLE_GAMEINSTRUCTIONS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Card m = cursorToInstructions(cursor);
            instructions.add(m);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return instructions;
    }

    public void addCard(Card m) {
        createCard(m);
    }

}



