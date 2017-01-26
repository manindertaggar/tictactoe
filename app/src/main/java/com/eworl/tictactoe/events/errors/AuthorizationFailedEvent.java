package com.eworl.tictactoe.events.errors;

/**
 * Created by root on 26/1/17.
 */

public class AuthorizationFailedEvent extends ErrorEvent {

    @Override
    protected void setId() {
        id = "AuthorizationFailed";
    }

    @Override
    protected void setMessage() {
    }
}
