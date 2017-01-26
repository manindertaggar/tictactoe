package com.goldducks.grabitusadmin.network.requests;

import android.content.Context;

import com.goldducks.grabitusadmin.network.callbacks.AddAdminCallback;
import com.goldducks.grabitusadmin.network.core.HttpRequest;
import com.goldducks.grabitusadmin.network.core.RequestCallback;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * Created by Maninder Taggar on 10/12/16.
 */

public class SampleRequest extends HttpRequest {

    public SampleRequest(Context context) {
        super(context);

    }

    public void start() {
        RequestBody formBody = new FormBody.Builder()
                .add("", "")
                .build();

        String url = "";
        RequestCallback callback = new AddAdminCallback(null);
        super.send(url, HttpRequest.POST, formBody, callback);

    }
}

