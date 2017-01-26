package com.eworl.tictactoe.events.incoming;

/**
 * Created by Maninder Taggar on 26/1/17.
 */

public class TimeoutEvent extends IncomingEvent {
    public static final String identity = "TimeoutEvent";

    @Override
    public void setIdentity() {
        super.identity = identity;
    }

}
