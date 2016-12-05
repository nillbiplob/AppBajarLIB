package com.aapbd.appbajarlib.print;

import android.util.Log;

public class Print {

    public static void message(String message) {

        Log.e("Message is:", message + "");

    }

    public static void message(String TAG, String message)
    {
        Log.e(TAG + "", message + "");
    }

}
