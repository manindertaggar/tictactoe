package com.eworl.tictactoe.services.messaging;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class SocketService extends FirebaseMessagingService {
    public SocketService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
    }

    @Override
    public void onSendError(String s, Exception e) {
        super.onSendError(s, e);
    }

}
