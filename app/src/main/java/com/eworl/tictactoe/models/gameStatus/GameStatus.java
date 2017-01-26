package com.eworl.tictactoe.models.gameStatus;

/**
 * Created by root on 26/1/17.
 */

public abstract class GameStatus {
    protected String status;

    public String getStatus() {
        return status;
    }

    protected abstract void setStatus();

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof GameStatus)) {
            return false;
        }

        return ((GameStatus) obj).getStatus().equals(getStatus());
    }

    @Override
    public String toString() {
        return "GameStatus: " + status;
    }
}
