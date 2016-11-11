package com.aapbd.appbajarlib.notification;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Window;
import android.widget.TextView;

import com.aapbd.appbajarlib.R;


public class BusyDialog {

    private final Dialog dialog;
    private TextView busyText;


    public BusyDialog(Context c, boolean cancelable, String text) {
        dialog = new Dialog(c,
                android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // here we set layout of progress dialog
        dialog.setContentView(R.layout.busylayout);
        dialog.setCancelable(cancelable);
        dialog.setCanceledOnTouchOutside(cancelable);
        busyText = (TextView) dialog.findViewById(R.id.busytextview);
        busyText.setText(text + "");
        busyText.setTextColor(Color.WHITE);
    }

	/*
     * constructor for colors
	 */

    public BusyDialog(Context c, boolean cancelable, String text, int textColor) {
        dialog = new Dialog(c,
                android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // here we set layout of progress dialog
        dialog.setContentView(R.layout.busylayout);
        dialog.setCancelable(cancelable);
        dialog.setCanceledOnTouchOutside(cancelable);
        busyText = (TextView) dialog.findViewById(R.id.busytextview);
        busyText.setText(text + "");
        busyText.setTextColor(textColor);
    }

    public BusyDialog(Context c, boolean cancelable) {
        dialog = new Dialog(c,
                android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // here we set layout of progress dialog
        dialog.setContentView(R.layout.busylayout);
        dialog.setCancelable(cancelable);
        dialog.setCanceledOnTouchOutside(cancelable);
    }


    public BusyDialog(Context c, boolean cancelable, String text, boolean isFulScreen) {
        if (isFulScreen) {
            dialog = new Dialog(c,
                    android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        } else {
            dialog = new Dialog(c,
                    android.R.style.Theme_Translucent_NoTitleBar);
//			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

        // here we set layout of progress dialog
        dialog.setContentView(R.layout.busylayout);
        dialog.setCancelable(cancelable);
        dialog.setCanceledOnTouchOutside(cancelable);
        busyText = (TextView) dialog.findViewById(R.id.busytextview);
        busyText.setText(text + "");
        busyText.setTextColor(Color.WHITE);
    }

	/*
	 * constructor for colors
	 */

    public BusyDialog(Context c, boolean cancelable, String text, int textColor, boolean isFulScreen) {
        if (isFulScreen) {
            dialog = new Dialog(c,
                    android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        } else {
            dialog = new Dialog(c,
                    android.R.style.Theme_Translucent_NoTitleBar);
//			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        // here we set layout of progress dialog
        dialog.setContentView(R.layout.busylayout);
        dialog.setCancelable(cancelable);
        dialog.setCanceledOnTouchOutside(cancelable);
        busyText = (TextView) dialog.findViewById(R.id.busytextview);
        busyText.setText(text + "");
        busyText.setTextColor(textColor);
    }

    public BusyDialog(Context c, boolean cancelable, boolean isFulScreen) {
        if (isFulScreen) {
            dialog = new Dialog(c,
                    android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        } else {
            dialog = new Dialog(c,
                    android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
                    //			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        // here we set layout of progress dialog
        dialog.setContentView(R.layout.busylayout);
        dialog.setCancelable(cancelable);
        dialog.setCanceledOnTouchOutside(cancelable);
    }


    public void show() {

        dialog.show();
    }

    public void dismis() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

}
