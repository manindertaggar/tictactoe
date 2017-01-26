package com.goldducks.grabitusadmin.network.requests;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;

import com.goldducks.grabitusadmin.constants.NetworkConstants;
import com.goldducks.grabitusadmin.network.callbacks.UpdateFcmTokenCallback;
import com.goldducks.grabitusadmin.network.core.HttpRequest;
import com.goldducks.grabitusadmin.utils.Database;
import com.goldducks.grabitusadmin.models.User;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * Created by Maninder Taggar on 10/12/16.
 */

public class UpdateFcmTokenRequest extends HttpRequest {
    User user = Database.getRunningInstance().getUser();
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
                .add("user_id", user.getId())
                .add("token", user.getToken())
                .add("deviceId", deviceId)
                .add("fcm_token", fcmToken)
                .build();
        Log.d(TAG, "updating token");
        String url = NetworkConstants.ROUTE_UPDATE_FCM_TOKEN;
        UpdateFcmTokenCallback callback = new UpdateFcmTokenCallback(context);
        super.send(url, HttpRequest.POST, formBody, callback);
    }
}

