package com.eworl.tictactoe;

import android.content.Context;

import com.eworl.tictactoe.models.Player;

/**
 * Created by Maninder Taggar on 26/1/17.
 */
public class Database {

    private static Database runningInstance;
    private Context context;

    public Database(Context context) {
        if (runningInstance != null) {
            return;
        }
        this.context = context;
        runningInstance = this;

    }

    public Player getPlayer() {
        return null;
    }

    public boolean isPlayerLoggedIn() {
        return false;
    }

    public static void init(Context baseContext) {
        new Database(baseContext);
    }

    public static Database getRunningInstance() {
        return runningInstance;
    }


}
