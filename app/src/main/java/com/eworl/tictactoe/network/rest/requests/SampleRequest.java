package com.eworl.tictactoe.network.rest.requests;

import android.content.Context;

import com.eworl.tictactoe.Database;
import com.eworl.tictactoe.Log;
import com.eworl.tictactoe.models.Player;
import com.eworl.tictactoe.network.rest.core.HttpRequest;
import com.eworl.tictactoe.network.rest.core.RequestCallback;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * Created by Maninder Taggar on 10/12/16.
 */

public class SampleRequest extends HttpRequest {

    public SampleRequest(Context context) {
        super(context);

    }

    public void start() {
        Database database = Database.getRunningInstance();
        if (!database.isPlayerLoggedIn()) {
            Log.w(getClass(), "start: user not logged in, so not sending call");
        }

        Player player = Database.getRunningInstance().getPlayer();
        RequestBody formBody = new FormBody.Builder()
                .add("playerId", player.getUserId())
                .add("token", player.getToken())
                .build();

        RequestCallback callback = null;
        super.send("", formBody, callback);

    }
}

