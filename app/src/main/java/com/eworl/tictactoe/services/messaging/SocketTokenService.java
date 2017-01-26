package com.eworl.tictactoe.services.messaging;

import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by root on 26/1/17.
 */

public class SocketTokenService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
    }
}
