package com.eworl.tictactoe.network.callbacks;

import android.content.Context;
import android.util.Log;

import com.eworl.tictactoe.network.core.Error;
import com.eworl.tictactoe.network.core.RequestCallback;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Maninder Taggar on 10/12/16.
 */

public class SampleCallback extends RequestCallback {
    private static final String TAG = SampleCallback.class.getCanonicalName();

    public SampleCallback(Context context) {
        super(context);
    }


    @Override
    public void onFailure(Call call, IOException e) {
        showError(e);
    }

    private void showError(Exception e) {
        Log.e(TAG, e.toString());
        getHandler().post(new Runnable() {
            @Override
            public void run() {
                //TODO: handler error here
            }
        });
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
                getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        //TODO: do something here
                    }
                });
            }
        } catch (JSONException e) {
            showError(e);
        }
    }
}


