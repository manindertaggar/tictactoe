package com.eworl.tictactoe.network.callbacks;

import android.util.Log;

import com.eworl.tictactoe.Database;
import com.eworl.tictactoe.activities.LoginActivity;
import com.eworl.tictactoe.network.core.RequestCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Maninder Taggar on 10/12/16.
 */

public class LoginCallback extends RequestCallback {
    private static final String TAG = LoginCallback.class.getCanonicalName();
    private LoginActivity activity;

    public LoginCallback(LoginActivity activity) {
        super(activity);
        this.activity = activity;
    }


    @Override
    public void onFailure(Call call, IOException e) {
        showError(e);

    }

    private void showError(final Exception e) {
        if (e != null)
            Log.e(TAG, e.toString());
        getHandler().post(new Runnable() {
            @Override
            public void run() {
                if (e != null)
                    activity.onLoginFailed(e.toString());
                else
                    activity.onLoginFailed("Incorrect username/password combination");
            }
        });
    }

    @Override
    public void onResponse(Call call, Response rawResponse) throws IOException {
        final String response = rawResponse.body().string();
        if (response.contains("error")) {
            showError(null);
        } else {
            getHandler().post(new Runnable() {
                @Override
                public void run() {
                    try {
                        JSONObject dataObject = new JSONObject(response).getJSONObject("data");
                 //       Database.getRunningInstance().createUser(user);
                        activity.onLoginSuccessful();
                    } catch (JSONException e) {
                        showError(e);
                    }
                }
            });
        }
    }
}

/*
{
  "data": {
    "name": "Maninder Singh",
    "user_id": "d18bfdb54ce97c6c1955d4b4839c1346",
    "email_id": "manindersingh030@gmail.com",
    "vehicle": "audi 6",
    "milage": "23 km/h",
    "last_service_date": "23 sept 2016",
    "phone_number": "9780181286",
    "token": "e29b33dfa449b4381ceeabcb11738bed"
  }
}
* */


