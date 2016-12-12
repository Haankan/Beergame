package com.example.hannes.beergame.Storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.hannes.beergame.common.CardDeck;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Hannes on 2016-12-05.
 */

public class DBCardDeckStore implements CardDeckStore {
    private static DBCardDeckStore storage ;

    private static final String LOG_TAG = DBCardDeckStore.class.getName();

    // Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.DECKS_COLUMN_ID,
            MySQLiteHelper.DECKS_COLUMN_NAME };

    public DBCardDeckStore(Context context)  {
        dbHelper = new MySQLiteHelper(context);
        try {
            open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CardDeck createCardDeck(CardDeck m) {
        ContentValues values = new ContentValues();

        values.put(MySQLiteHelper.DECKS_COLUMN_NAME, m.name());
        //values.put(MySQLiteHelper.COLUMN_EMAIL, m.());

        long insertId = database.insert(MySQLiteHelper.TABLE_CARDDECKS, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_CARDDECKS,
                allColumns, MySQLiteHelper.DECKS_COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        CardDeck newCardDeck = cursorToCardDeck(cursor);
        cursor.close();
        Log.d("db" ," storing carddeck");
        return newCardDeck;
    }

    private CardDeck cursorToCardDeck(Cursor cursor) {
        long id = cursor.getLong(0);
        String name = cursor.getString(1);
        //String email = cursor.getString(2);
        return new CardDeck(name);
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
    public List<CardDeck> getCardDeck() {
        List<CardDeck> carddecks = new ArrayList<>();

        Log.d(LOG_TAG, "getCardDeck()");
        Log.d(LOG_TAG, "getCardDeck : " + database);
        Log.d(LOG_TAG, "getCardDeck : " + allColumns);

        Cursor cursor = database.query(MySQLiteHelper.TABLE_CARDDECKS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            CardDeck m = cursorToCardDeck(cursor);
            carddecks.add(m);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return carddecks;
    }

    public void addCardDeck(CardDeck m) {
        createCardDeck(m);
    }

}
