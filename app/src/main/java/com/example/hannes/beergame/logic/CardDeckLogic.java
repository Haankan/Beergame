package com.example.hannes.beergame.logic;

import android.content.Context;

import com.example.hannes.beergame.common.CardDeck;

import java.lang.reflect.Member;
import java.util.List;

/**
 * Created by Hannes on 2016-12-05.
 */

public class CardDeckLogic {
    private Context c;

    public CardDeckLogic(Context c) {
        this.c = c;
    }

    public List<Member> getMembers() {
        return StorageProvider.getMemberStore(c).getMembers();
    }

    public void addMember(Member m) {
        StorageProvider.getMemberStore(c).addMember(m);
    }
}
