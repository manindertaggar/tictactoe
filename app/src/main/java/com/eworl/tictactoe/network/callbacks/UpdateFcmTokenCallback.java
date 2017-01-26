package com.eworl.tictactoe.network.callbacks;

import android.content.Context;

import com.eworl.tictactoe.Log;
import com.eworl.tictactoe.network.core.Error;
import com.eworl.tictactoe.network.core.RequestCallback;
import com.eworl.tictactoe.network.requests.UpdateFcmTokenRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Maninder Taggar on 10/12/16.
 */

public class UpdateFcmTokenCallback extends RequestCallback {

    public UpdateFcmTokenCallback(Context context) {
        super(context);
    }


    @Override
    public void onFailure(Call call, IOException e) {
        showError(e);
    }

    private void showError(Exception e) {
        Log.e(getClass(), e.toString());
        new UpdateFcmTokenRequest(getContext()).start();
    }

    @Override
    public void onResponse(Call call, Response rawResponse) throws IOException {
        final String response = rawResponse.body().string();
        try {
            JSONObject dataObject = new JSONObject(response);
            if (dataObject.getBoolean("isError")) {
                Error error = new Gson().fromJson(dataObject.toString(), Error.class);
                showError(error.getException());
            } else {
                Log.i(getClass(), "onResponse: " + response);
            }
        } catch (JSONException e) {
            showError(e);
        }
    }
}


