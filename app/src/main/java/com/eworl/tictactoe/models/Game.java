package com.eworl.tictactoe.models;

import com.eworl.tictactoe.models.gameStatus.GameStatus;

/**
 * Created by root on 26/1/17.
 */

public class Game {
    private String id;
    private Player player2;
    private GameStatus gameStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
