package com.eworl.tictactoe;

import android.app.Application;

import com.eworl.tictactoe.utils.MessageIdGenerator;

/**
 * Created by root on 26/1/17.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Database.init(getBaseContext());
        MessageIdGenerator.init(getBaseContext());
    }
}
