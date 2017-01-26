package com.eworl.tictactoe.network.rest.core;

import android.content.Context;

import com.eworl.tictactoe.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Maninder Taggar on 12/4/16.
 */
public abstract class HttpRequest {
    public static final String POST = "post";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_TEXT_JSON = "text/json";
    private static final String TAG = HttpRequest.class.getCanonicalName();
    final Context mContext;


    public HttpRequest(Context context) {
        mContext = context;
    }

    protected Context getContext() {
        return mContext;
    }


    public void send(String url, RequestBody requestBody, RequestCallback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build();

        Request.Builder requestBuilder = new Request.Builder()
                .addHeader(HEADER_CONTENT_TYPE, HEADER_TEXT_JSON)
                .url(url);

        Request httpRequest = requestBuilder.post(requestBody).build();

        Log.i(getClass(), "send: \nurl:" + url + "\nresponseBody: " + requestBody.toString());
        client.newCall(httpRequest).enqueue(callback);

    }

}
