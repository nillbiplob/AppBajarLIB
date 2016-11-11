package com.aapbd.appbajarlib.notification;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MyToast {

	/*
     * show toast
	 */

    public static void showToast(Context c, String text) {
        Toast.makeText(c, text, Toast.LENGTH_LONG).show();

    }

    public static void showToast(Context c, String text, int length) {
        Toast.makeText(c, text, length).show();

    }

    public static void customToast(Context con,  String tText, String toastLength) {

        final Toast toast;

        if (toastLength.equalsIgnoreCase("s")) {
            toast = Toast.makeText(con, tText, Toast.LENGTH_SHORT);
        } else {
            toast = Toast.makeText(con, tText, Toast.LENGTH_LONG);
        }

        View tView = toast.getView();
        tView.setBackgroundColor(Color.parseColor("#CC000000"));
        TextView mText = (TextView) tView.findViewById(android.R.id.message);
        mText.setTextColor(Color.WHITE);

        mText.setShadowLayer(4, 4, 4, 4);

        tView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                toast.cancel();
            }
        });

        tView.invalidate();

        toast.setGravity(Gravity.CENTER,0,0);

         toast.show();

    }


}
