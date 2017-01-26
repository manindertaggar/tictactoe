package com.eworl.tictactoe.events.errors;

/**
 * Created by Maninder Taggar on 26/1/17.
 */

public class MoveFailedEvent extends ErrorEvent {
    @Override
    protected void setId() {
        id = "MoveFailed";

    }

    @Override
    protected void setMessage() {

    }
}
