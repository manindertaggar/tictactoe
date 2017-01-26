package com.eworl.tictactoe;

import com.eworl.tictactoe.models.Player;

/**
 * Created by Maninder Taggar on 26/1/17.
 */
public class Database {

    private static Database runningInstance;

    public static Database getRunningInstance() {
        return runningInstance;
    }

    public Player getPlayer() {
        return null;
    }

    public boolean isPlayerLoggedIn() {
        return false;
    }
}
