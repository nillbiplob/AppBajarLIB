package com.aapbd.appbajarlib.view;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

public class FullScreenActivity {

    public static void fullScreen(Activity con) {

        con.requestWindowFeature(Window.FEATURE_NO_TITLE);
        con.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
