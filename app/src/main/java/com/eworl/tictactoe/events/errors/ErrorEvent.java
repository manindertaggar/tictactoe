package com.eworl.tictactoe.events.errors;

import com.eworl.tictactoe.events.Event;

/**
 * Created by root on 26/1/17.
 */

public abstract class ErrorEvent extends Event {
    String id, message;

    public String getId() {
        return id;
    }

    protected abstract void setId(String id);

    public String getMessage() {
        return message;
    }

    protected abstract void setMessage(String message);
}
