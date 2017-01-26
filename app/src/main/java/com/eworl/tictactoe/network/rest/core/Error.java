package com.eworl.tictactoe.network.rest.core;

/**
 * Created by root on 26/1/17.
 */

public class Error {
    private String id, message;
    private Exception exception;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Exception getException() {
        if (exception == null)
            exception = new Exception(toString());
        return exception;
    }

    @Override
    public String toString() {
        return "Error:\nid:" + message + "\nmessage: " + message;
    }
}
