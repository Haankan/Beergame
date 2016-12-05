package com.example.hannes.beergame.Storage;

import android.content.Context;

/**
 * Created by Hannes on 2016-12-05.
 */

public class StorageProvider {
    public static CardDeckStore getMemberStore(Context c) {
        return new DBCardDeckStore(c);
    }
}
