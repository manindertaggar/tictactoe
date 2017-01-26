package com.eworl.tictactoe.network.core;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Maninder Taggar on 12/4/16.
 */
public abstract class HttpRequest {
    private static final String TAG = HttpRequest.class.getCanonicalName();

    public static final String POST = "post";

    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_TEXT_JSON = "text/json";

    final Context mContext;


    public HttpRequest(Context context) {
        mContext = context;
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

        client.newCall(httpRequest).enqueue(callback);

    }

}
