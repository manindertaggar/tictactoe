package com.eworl.tictactoe.network.callbacks;

import android.content.Context;
import android.util.Log;


import com.eworl.tictactoe.network.core.RequestCallback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Maninder Taggar on 10/12/16.
 */

public class UpdateFcmTokenCallback extends RequestCallback {
    private static final String TAG = UpdateFcmTokenCallback.class.getCanonicalName();

    public UpdateFcmTokenCallback(Context context) {
        super(context);
    }


    @Override
    public void onFailure(Call call, IOException e) {
        Log.e(TAG, e.toString());
    }


    @Override
    public void onResponse(Call call, Response rawResponse) throws IOException {
        final String response = rawResponse.body().string();
        Log.d(TAG, "onResponse: " + response);
    }
}


