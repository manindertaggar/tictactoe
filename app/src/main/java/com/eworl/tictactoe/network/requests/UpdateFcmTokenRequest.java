package com.eworl.tictactoe.network.requests;

import android.content.Context;

import com.eworl.tictactoe.Database;
import com.eworl.tictactoe.Log;
import com.eworl.tictactoe.models.Player;
import com.eworl.tictactoe.network.NetworkConstants;
import com.eworl.tictactoe.network.callbacks.UpdateFcmTokenCallback;
import com.eworl.tictactoe.network.core.HttpRequest;
import com.google.firebase.iid.FirebaseInstanceId;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * Created by Maninder Taggar on 10/12/16.
 */

public class UpdateFcmTokenRequest extends HttpRequest {

    public UpdateFcmTokenRequest(Context context) {
        super(context);
    }

    public void start() {
        Database database = Database.getRunningInstance();
        if (!database.isPlayerLoggedIn()) {
            Log.w(getClass(), "start: user is not loggedin so not updating FCMTOKEN");
            return;
        }

        Player player = database.getPlayer();
        String fcmToken = FirebaseInstanceId.getInstance().getToken();

        RequestBody formBody = new FormBody.Builder()
                .add("userId", player.getUserId())
                .add("token", player.getToken())
                .add("fcmToken", fcmToken)
                .build();

        Log.d(getClass(), "updating token" + fcmToken);

        UpdateFcmTokenCallback callback = new UpdateFcmTokenCallback(getContext());
        super.send(NetworkConstants.ROUTE_UPDATE_FCM_TOKEN, formBody, callback);
    }


}

