package com.eworl.tictactoe.network.requests;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;

import com.eworl.tictactoe.network.NetworkConstants;
import com.eworl.tictactoe.network.callbacks.UpdateFcmTokenCallback;
import com.eworl.tictactoe.network.core.HttpRequest;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * Created by Maninder Taggar on 10/12/16.
 */

public class UpdateFcmTokenRequest extends HttpRequest {

    private String TAG = UpdateFcmTokenRequest.class.getCanonicalName();
    Context context;

    public UpdateFcmTokenRequest(Context context) {
        super(context);
        this.context = context;
    }

    public void start(String fcmToken) {
        String deviceId = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        RequestBody formBody = new FormBody.Builder()
                .add("user_id", "")
                .add("token", "")
                .add("fcm_token", fcmToken)
                .build();
        Log.d(TAG, "updating token");
        String url = NetworkConstants.ROUTE_UPDATE_FCM_TOKEN;
        UpdateFcmTokenCallback callback = new UpdateFcmTokenCallback(context);
        super.send(url, formBody, callback);
    }
}

