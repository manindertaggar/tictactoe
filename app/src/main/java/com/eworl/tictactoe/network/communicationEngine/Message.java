package com.eworl.tictactoe.network.communicationEngine;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by root on 26/1/17.
 */

public class Message {
    private String playerId, token;
    private JSONObject payload;

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }


    public void setToken(String token) {
        this.token = token;
    }


    public void setPayload(JSONObject payload) {
        this.payload = payload;
    }

    public String getMessage() {
        return toString();
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("playerId", playerId);
            jsonObject.put("token", token);
            jsonObject.put("payload", payload);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString()
                ;
    }
}
