package com.eworl.tictactoe.events.incoming;

/**
 * Created by Maninder Taggar on 26/1/17.
 */

public class GameStartEvent extends IncomingEvent {
    public static final String identity = "GameStartEvent";

    @Override
    public void setIdentity() {
        super.identity = identity;
    }

}
