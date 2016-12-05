package com.example.hannes.beergame.Storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hannes on 2016-12-05.
 */

public class DBCardDeckStore implements CardDeckStore {
    private static DBCardDeckStore storage ;

    // Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_NAME, MySQLiteHelper.COLUMN_EMAIL };

    public DBCardDeckStore(Context context)  {
        dbHelper = new MySQLiteHelper(context);
        try {
            open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Member createMember(Member m) {
        ContentValues values = new ContentValues();

        values.put(MySQLiteHelper.COLUMN_NAME, m.name());
        values.put(MySQLiteHelper.COLUMN_EMAIL, m.email());

        long insertId = database.insert(MySQLiteHelper.TABLE_MEMBERS, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_MEMBERS,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Member newMember = cursorToMember(cursor);
        cursor.close();
        Log.d("db" ," storing meber");
        return newMember;
    }

    private Member cursorToMember(Cursor cursor) {
        long id = cursor.getLong(0);
        String name = cursor.getString(1);
        String email = cursor.getString(2);
        return new Member(name, email);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    @Override
    public List<Member> getMembers() {
        List<Member> members = new ArrayList<Member>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_MEMBERS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Member m = cursorToMember(cursor);
            members.add(m);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return members;
    }

    public void addMember(Member m) {
        createMember(m);
    }

}
