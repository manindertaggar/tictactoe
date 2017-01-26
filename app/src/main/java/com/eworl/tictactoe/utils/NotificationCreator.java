package com.eworl.tictactoe.utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import com.eworl.tictactoe.Log;
import com.eworl.tictactoe.R;
import com.eworl.tictactoe.activities.MainActivity;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by root on 26/1/17.
 */

public class NotificationCreator {
    private Context context;

    public static void create(Context context, String title, String contentText) {
        Log.i(NotificationCreator.class, "create: creating notification:\ntitle: " + title + "\n" + contentText);
        android.support.v4.app.NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(title)
                        .setContentText(contentText);

        Intent resultIntent = new Intent(context, MainActivity.class);
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setAutoCancel(true);
        mBuilder.setContentIntent(resultPendingIntent);
        int mNotificationId = 0;
        NotificationManager mNotifyMgr =
                (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mNotificationId, mBuilder.build());

    }

}
