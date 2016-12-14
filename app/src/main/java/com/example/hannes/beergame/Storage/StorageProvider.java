package com.example.hannes.beergame.Storage;

import android.content.Context;

/**
 * Created by Hannes on 2016-12-05.
 */

public class StorageProvider {
    public static CardDeckStore getCardDeckStore(Context c) {
        return new DBCardDeckStore(c);
    }
    public static CardStore getCardStore(Context c) {
        return new DBCardStore(c);

    }
}
