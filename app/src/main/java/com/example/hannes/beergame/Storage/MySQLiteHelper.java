package com.example.hannes.beergame.Storage;

/**
 * Created by v on 2016-11-30.
 * Inspirerats av Henriks databasklasser och hjälpmedel
 *
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class MySQLiteHelper extends SQLiteOpenHelper {


    public static final String TABLE_CARDS = "cards";
    public static final String CARDS_COLUMN_ID     = "_id";
    public static final String CARDS_COLUMN_TYPE   = "typ";
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
    private static final String CARDS_TABLE_CREATE = "create table "
            + TABLE_CARDS + "( "
            + CARDS_COLUMN_ID     + " integer primary key autoincrement, "
            + CARDS_COLUMN_TYPE   +  " integer not null,"
            + CARDS_COLUMN_NUMBER  +  " integer not null);";


     private static final String DECKS_TABLE_CREATE = "create table "
            + TABLE_CARDDECKS + "( "
            + DECKS_COLUMN_ID     + " integer primary key autoincrement, "
            + DECKS_COLUMN_NAME  +  " text not null);";

     private static final String GAMEINSTRUCTIONS_TABLE_CREATE = "create table "
            + TABLE_GAMEINSTRUCTIONS + "( "
             + INSTR_COLUMN_CARDDECKSID  + " integer,"
             + INSTR_COLUMN_CARDSID      + " integer,"
             + INSTR_COLUMN_INSTRUCTIONS +  " text not null,"
             + " FOREIGN KEY (" + INSTR_COLUMN_CARDDECKSID + ")  REFERENCES " + TABLE_CARDDECKS + "("+DECKS_COLUMN_ID+"),"
             + " FOREIGN KEY (" + INSTR_COLUMN_CARDSID     + ")  REFERENCES " + TABLE_CARDS+"("+CARDS_COLUMN_ID+")" +
             ");";



    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CARDS_TABLE_CREATE);
        database.execSQL(DECKS_TABLE_CREATE);
        Log.d(LOG_TAG, "create game instructions: " + GAMEINSTRUCTIONS_TABLE_CREATE);
        database.execSQL(GAMEINSTRUCTIONS_TABLE_CREATE);
        //typer 1 = hjärter 2 = spader 3 ruter 4 = klöver
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (1, 1, 2)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (2, 1, 3)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (3, 1, 4)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (4, 1, 5)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (5, 1, 6)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (6, 1, 7)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (7, 1, 8)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (8, 1, 9)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (9, 1, 10)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (10, 1, 11)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (11, 1, 12)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (12, 1, 13)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (13, 1, 14)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (14, 2, 2)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (15, 2, 3)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (16, 2, 4)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (17, 2, 5)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (18, 2, 6)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (19, 2, 7)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (20, 2, 8)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (21, 2, 9)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (22, 2, 10)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (23, 2, 11)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (24, 2, 12)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (25, 2, 13)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (26, 2, 14)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (27, 3, 2)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (28, 3, 3)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (29, 3, 4)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (30, 3, 5)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (31, 3, 6)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (32, 3, 7)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (33, 3, 8)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (34, 3, 9)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (35, 3, 10)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (36, 3, 11)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (37, 3, 12)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (38, 3, 13)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (39, 3, 14)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (40, 4, 2)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (41, 4, 3)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (42, 4, 4)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (43, 4, 5)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (44, 4, 6)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (45, 4, 7)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (46, 4, 8)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (47, 4, 9)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (48, 4, 10)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (49, 4, 11)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (50, 4, 12)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (51, 4, 13)");
        database.execSQL("INSERT INTO " + TABLE_CARDS + " VALUES (52, 4, 14)");

        database.execSQL("INSERT INTO " + TABLE_CARDDECKS + " VALUES (1, 'Standarddd')");
        database.execSQL("INSERT INTO " + TABLE_CARDDECKS + " VALUES (2, 'Viktors')");
        database.execSQL("INSERT INTO " + TABLE_CARDDECKS + " VALUES (3, 'Hannes')");


        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 1, 'Drick två klunkar.')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 2, 'Drick tre klunkar.')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 3, 'Drick fyra klunkar.')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 4, 'Drick fem klunkar.')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 5, 'Drick sex klunkar.')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 6, 'RÄKNELEK! Spelaren som drog kortet " +
                "börjar räkna säga ett sen fortsätter spelaren till vänster med att säga två, osv.. Alla tal som antingen är delbart med siffran sju " +
                "eller innehåller siffran sju ska ersättas med att säga ÖL!, den som först misslyckas med att göra detta får ta tre straffklunkar.')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 7, 'TUMMLEK! Den som drog kortet" +
                " får när som helst under spelets gång placera en tumme på bordet, därefter ska resterande spelare göra detsamma. " +
                "Den som är sist med tummen på bordet får dricka tre klunkar')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 8, 'TEMA! Spelaren som drog kortet väljer ett tema(t.ex Huvudstäder) Sedan " +
                "ska alla spelare i turordning säga en huvudstad, den som till slut inte kommer på någon huvudstad eller tvekar får då dricka tre klunkar')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 9, 'REGEL! Spelaren som drog kortet får bestämma en valfri regel som alla spelare måste" +
                " följa resten av spelets gång, om någon inte följer regeln får denne ta tre klunkar.')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 10, 'Dric10k')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 11, 'Drick11')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 12, 'Drick12')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 13, 'Drick13')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 14, 'Drick14')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 15, 'Drick15')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 16, 'Drick16')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 17, 'Drick17')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 18, 'Drick18')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 19, 'Drick19')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 20, 'Drick20')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 21, 'Drick21')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 22, 'Drick22')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 23, 'Drick23')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 24, 'Drick24')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 25, 'Drick25')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 26, 'Drick26')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 27, 'Drick27')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 28, 'Drick28')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 29, 'Drick29')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 30, 'Drick30')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 31, 'Drick31')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 32, 'Drick32')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 33, 'Drick33')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 34, 'Drick34')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 35, 'Drick35')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 36, 'Drick36')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 37, 'Drick37')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 38, 'Drick38')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 39, 'Drick39')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 40, 'Drick40')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 41, 'Drick41')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 42, 'Drick42')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 43, 'Drick43')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 44, 'Drick44')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 45, 'Drick45')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 46, 'Drick46')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 47, 'Drick47')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 48, 'Drick48')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 49, 'Drick49')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 50, 'Drick50')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 51, 'Drick51')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (1, 52, 'Drick52')");

        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 1, 'Dricsdfk1')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 2, 'Ddsfrick2')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 3, 'Dricdsfsdfk3')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 4, 'dfDrickdsfd4')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 5, 'Ddfdsrick5')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 6, 'Drdsfick6')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 7, 'Drdfsdick7')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 8, 'Dricdfk8')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 9, 'Dricdffddsk9')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 10, 'Dric10dsfk')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 11, 'Dridfdfck11')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 12, 'Dsdfrick12')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 13, 'Drddffdsfsick13')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 14, 'Ddsfrick14')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 15, 'Drdsfdsfick15')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 16, 'Drdsfsdfick16')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 17, 'Drdsfsdfick17')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 18, 'Dridsfsdfck18')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 19, 'Drdsfsdfick19')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 20, 'Drdsfsdfick20')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 21, 'Drdsfsdfick21')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 22, 'Dridsfsdfck22')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 23, 'Dridsfsdfck23')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 24, 'Dridsffck24')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 25, 'Dridfsfsdck25')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 26, 'Drisdfdsfck26')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 27, 'Dridsfsdfck27')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 28, 'Dridsfsdfck28')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 29, 'Dridsfsdfck29')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 30, 'Drdsffsdick30')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 31, 'Drisdfsdfck31')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 32, 'Drdsfsdck32')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 33, 'Drifsdfdsck33')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 34, 'Drfdsfsdfick34')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 35, 'Drsdfsdfick35')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 36, 'Drsdfsdfick36')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 37, 'Dsdfsdfrick37')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 38, 'Drisdfsdck38')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 39, 'Drsdfsdfick39')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 40, 'Ddsfdsfrick40')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 41, 'Dsdfdsick41')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 42, 'Drfsdfick42')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 43, 'Dridsfdsck43')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 44, 'Dridsfsdfck44')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 45, 'Drifdsfck45')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 46, 'Dridsfdsfck46')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 47, 'Drifsdfsdck47')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 48, 'Drsdfsdick48')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 49, 'Drifsdfck49')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 50, 'Dridsfsdfck50')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 51, 'Drisdfdsfck51')");
        database.execSQL("INSERT INTO " + TABLE_GAMEINSTRUCTIONS + " VALUES (2, 52, 'Drdsfck52')");


        }
    public List<String> getAllinstructions(){
        List<String> decks = new ArrayList<String>();


        String selectQuery = "SELECT  * FROM " + TABLE_CARDDECKS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // loopar igenom alla rader och lägger i lista
        decks.add("Choose deck");
        if (cursor.moveToFirst()) {
            do {

                decks.add(cursor.getString(1));

            } while (cursor.moveToNext());
        }


        cursor.close();
        db.close();


        return decks;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.d(LOG_TAG, " can't upgrade");
    }

}

