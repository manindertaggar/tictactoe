package com.eworl.tictactoe.models.gameStatus;

/**
 * Created by Maninder Taggar on 26/1/17.
 */

public class Lost extends GameStatus {
    @Override
    protected void setStatus() {
        status = "lost";
    }
}
