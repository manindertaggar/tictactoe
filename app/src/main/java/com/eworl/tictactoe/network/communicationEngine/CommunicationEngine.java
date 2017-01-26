package com.eworl.tictactoe.network.communicationEngine;

import android.content.Context;

import com.eworl.tictactoe.AppConstants;
import com.eworl.tictactoe.Log;
import com.eworl.tictactoe.events.incoming.AcheivementEvent;
import com.eworl.tictactoe.events.incoming.GameEndEvent;
import com.eworl.tictactoe.events.incoming.GameRequestEvent;
import com.eworl.tictactoe.events.incoming.GameStartEvent;
import com.eworl.tictactoe.events.incoming.MoveMadeEvent;
import com.eworl.tictactoe.events.incoming.RankUpgradeEvent;
import com.eworl.tictactoe.events.incoming.TimeoutEvent;
import com.eworl.tictactoe.utils.MessageIdGenerator;
import com.eworl.tictactoe.utils.NotificationCreator;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by root on 26/1/17.
 */

public class CommunicationEngine {

    public static void sendMessage(Message message) {
        Log.i(CommunicationEngine.class, "sendMessage: " + message);

        FirebaseMessaging fm = FirebaseMessaging.getInstance();
        fm.send(new RemoteMessage.Builder(AppConstants.FCM_SENDER_ID + "@gcm.googleapis.com")
                .setMessageId(Integer.toString(MessageIdGenerator.incrementAndGet()))
                .addData("data", message.getMessage())
                .build());
    }

    public static void parseMessage(Context context, Map<String, String> data) {
        String type = data.get("type");
        switch (type) {
            case "alert":
                createAlert(context, data);
                break;
            case AcheivementEvent.identity:
                recievedAcheivementEvent(data);
                break;
            case GameEndEvent.identity:
                recievedGameEndEvent(data);
                break;
            case GameRequestEvent.identity:
                recievedGameRequestEvent(data);
                break;
            case GameStartEvent.identity:
                recievedGameStartEvent(data);
                break;
            case MoveMadeEvent.identity:
                recievedMoveMadeEvent(data);
                break;
            case RankUpgradeEvent.identity:
                recievedRankUpgradeEvent(data);
                break;
            case TimeoutEvent.identity:
                recievedTimeoutEvent(data);
                break;


        }
    }

    private static void recievedTimeoutEvent(Map<String, String> rawData) {
        try {
            JSONObject data = new JSONObject(rawData.get("data"));
            TimeoutEvent timeoutEvent = new Gson().fromJson(data.toString(), TimeoutEvent.class);
        } catch (JSONException e) {
            Log.e(CommunicationEngine.class, e.toString());
        }

    }

    private static void recievedRankUpgradeEvent(Map<String, String> rawData) {
        try {
            JSONObject data = new JSONObject(rawData.get("data"));
            RankUpgradeEvent rankUpgradeEvent = new Gson().fromJson(data.toString(), RankUpgradeEvent.class);
        } catch (JSONException e) {
            Log.e(CommunicationEngine.class, e.toString());
        }

    }

    private static void recievedMoveMadeEvent(Map<String, String> rawData) {
        try {
            JSONObject data = new JSONObject(rawData.get("data"));
            MoveMadeEvent moveMadeEvent = new Gson().fromJson(data.toString(), MoveMadeEvent.class);
        } catch (JSONException e) {
            Log.e(CommunicationEngine.class, e.toString());
        }

    }

    private static void recievedGameStartEvent(Map<String, String> rawData) {
        try {
            JSONObject data = new JSONObject(rawData.get("data"));
            GameStartEvent gameStartEvent = new Gson().fromJson(data.toString(), GameStartEvent.class);
        } catch (JSONException e) {
            Log.e(CommunicationEngine.class, e.toString());
        }

    }

    private static void recievedGameRequestEvent(Map<String, String> rawData) {
        try {
            JSONObject data = new JSONObject(rawData.get("data"));
            GameRequestEvent gameRequestEvent = new Gson().fromJson(data.toString(), GameRequestEvent.class);
        } catch (JSONException e) {
            Log.e(CommunicationEngine.class, e.toString());
        }

    }

    private static void recievedGameEndEvent(Map<String, String> rawData) {
        try {
            JSONObject data = new JSONObject(rawData.get("data"));
            GameEndEvent gameEndEvent = new Gson().fromJson(data.toString(), GameEndEvent.class);
        } catch (JSONException e) {
            Log.e(CommunicationEngine.class, e.toString());
        }

    }

    private static void recievedAcheivementEvent(Map<String, String> rawData) {
        try {
            JSONObject data = new JSONObject(rawData.get("data"));
            AcheivementEvent acheivementEvent = new Gson().fromJson(data.toString(), AcheivementEvent.class);
        } catch (JSONException e) {
            Log.e(CommunicationEngine.class, e.toString());
        }

    }

    private static void createAlert(Context context, Map<String, String> rawData) {
        try {
            JSONObject data = new JSONObject(rawData.get("data"));
            String title = data.getString("title");
            String contentText = data.getString("contentText");
            NotificationCreator.create(context, title, contentText);
        } catch (JSONException e) {
            Log.e(CommunicationEngine.class, e.toString());
        }
    }
}
