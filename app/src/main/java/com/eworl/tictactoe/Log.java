package com.eworl.tictactoe;

/**
 * Created by Maninder Taggar on 26/1/17.
 */

public class Log {
    private static final boolean SHOW_LOGS = true;

    public static int d(Class className, String message) {
        if (SHOW_LOGS)
            return android.util.Log.d(className.getCanonicalName(), message);
        return 0;
    }

    public static int e(Class className, String message) {
        if (SHOW_LOGS)
            return android.util.Log.e(className.getCanonicalName(), message);
        return 0;
    }

    public static int i(Class className, String message) {
        if (SHOW_LOGS)
            return android.util.Log.i(className.getCanonicalName(), message);
        return 0;
    }

    public static int w(Class className, String message) {
        if (SHOW_LOGS)
            return android.util.Log.w(className.getCanonicalName(), message);
        return 0;
    }

}
