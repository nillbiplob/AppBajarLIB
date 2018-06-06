package com.aapbd.appbajarlib.view;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class FullScreenActivity {

    public static void fullScreen(Activity con) {


        con.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



        if (Build.VERSION.SDK_INT < 16) {
            con.requestWindowFeature(Window.FEATURE_NO_TITLE);
            con.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else
        {
            View decorView = con.getWindow().getDecorView();
// Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
// Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.
            ActionBar actionBar = con.getActionBar();

            if(actionBar!=null) {
                actionBar.hide();
            }
        }


    }

    public static void fullScreen(AppCompatActivity con) {


        con.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



        if (Build.VERSION.SDK_INT < 16) {
            con.requestWindowFeature(Window.FEATURE_NO_TITLE);
            con.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else
        {
            View decorView = con.getWindow().getDecorView();
// Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
// Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.
            android.support.v7.app.ActionBar actionBar = con.getSupportActionBar();

            if(actionBar!=null) {
                actionBar.hide();
            }
        }


    }
}
