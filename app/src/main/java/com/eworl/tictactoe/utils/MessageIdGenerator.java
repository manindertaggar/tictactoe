package com.eworl.tictactoe.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by root on 26/1/17.
 */

public class MessageIdGenerator {
    private static int msgId = 0;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    public static void init(Context context) {
        sharedPreferences = context.getSharedPreferences("MessageId", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static int incrementAndGet() {
        msgId = sharedPreferences.getInt("id", 0);
        msgId++;
        editor.putInt("id", msgId).apply();
        return msgId;
    }
}
