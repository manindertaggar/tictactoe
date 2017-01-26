package com.eworl.tictactoe.network.rest.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import okhttp3.Callback;

/**
 * Created by Maninder Taggar on 06/06/16.
 */
public abstract class RequestCallback implements Callback {

    private Context context;
    private Handler handler = new Handler(Looper.getMainLooper());

    public RequestCallback(Context context) {
        this.context = context;
    }

    protected Handler getHandler() {
        return handler;
    }

    protected Context getContext() {
        return context;
    }
}

