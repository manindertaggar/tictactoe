package com.eworl.tictactoe.events.errors;

import com.eworl.tictactoe.events.Event;

/**
 * Created by Maninder Taggar on 26/1/17.
 */

public abstract class ErrorEvent extends Event {
    protected String id, message;

    public String getId() {
        return id;
    }

    protected abstract void setId();

    public String getMessage() {
        return message;
    }

    protected abstract void setMessage();


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof ErrorEvent)) {
            return false;
        }

        return ((ErrorEvent) obj).getId().equals(getId());

    }

    @Override
    public String toString() {
        return "errorEvent:\nid: " + getMessage() + "\nmessage: " + getMessage();
    }
}
