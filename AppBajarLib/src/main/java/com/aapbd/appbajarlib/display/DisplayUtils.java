package com.aapbd.appbajarlib.display;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;

@SuppressLint("NewApi")
public class DisplayUtils {

    public static int dpToPx(Resources res, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                res.getDisplayMetrics());
    }

    public static void fullScreen(Activity con) {

        con.requestWindowFeature(Window.FEATURE_NO_TITLE);
        con.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public static Point getScreenSize(Activity act) {
        int screenWidth = 0;
        int screenHeight = 0;
        if (Build.VERSION.SDK_INT >= 17) {
            final Point size = new Point();
            try {
                act.getWindowManager().getDefaultDisplay().getRealSize(size);
                screenWidth = size.x;
                screenHeight = size.y;
            } catch (final NoSuchMethodError e) {
                screenHeight = act.getWindowManager().getDefaultDisplay()
                        .getHeight();
                screenWidth = act.getWindowManager().getDefaultDisplay()
                        .getWidth();
            }

        } else {
            final DisplayMetrics metrics = new DisplayMetrics();
            act.getWindowManager().getDefaultDisplay().getMetrics(metrics);
            screenWidth = metrics.widthPixels;
            screenHeight = metrics.heightPixels;
        }
        return new Point(screenWidth, screenHeight);

    }

}
