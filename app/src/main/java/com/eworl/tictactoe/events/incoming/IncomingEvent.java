package com.eworl.tictactoe.events.incoming;

import com.eworl.tictactoe.events.Event;

/**
 * Created by Maninder Taggar on 26/1/17.
 */

public abstract class IncomingEvent extends Event {
    protected String identity;

    public String getIdentity() {
        return identity;
    }

    public abstract void setIdentity();
}
