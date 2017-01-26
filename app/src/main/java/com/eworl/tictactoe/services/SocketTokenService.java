package com.eworl.tictactoe.services;

import com.eworl.tictactoe.network.rest.requests.UpdateFcmTokenRequest;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Maninder Taggar on 26/1/17.
 */

public class SocketTokenService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        new UpdateFcmTokenRequest(this).start();
    }
}
