package com.aapbd.appbajarlib.view;

import android.content.Context;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by shafiulalambiplob on 23/12/15.
 */
public class StatusBarUtils {

    public static void changeStatusBarColor(Context con,Window window, int color) {

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(con.getResources().getColor(color));
        }

    }
}
