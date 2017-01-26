package com.eworl.tictactoe.services;

import com.eworl.tictactoe.Log;
import com.eworl.tictactoe.network.communicationEngine.CommunicationEngine;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class SocketService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.i(getClass(), "onMessageRecieved");
        if (remoteMessage.getData().size() > 0) {
            CommunicationEngine.parseMessage(getBaseContext(), remoteMessage.getData());
        } else {
            Log.w(getClass(), "onMessageRecieved:  no data found in message");
        }
    }

}
