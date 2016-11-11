package com.aapbd.appbajarlib.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

import com.aapbd.appbajarlib.R;


public class AppRater {

    private final static int DAYS_UNTIL_PROMPT = 0;
    private final static int LAUNCHES_UNTIL_PROMPT = 0;

    public static boolean app_launchedBefore24Hours(Context mContext) {
        final SharedPreferences prefs = mContext.getSharedPreferences(
                "apprater", 0);

        final SharedPreferences.Editor editor = prefs.edit();

        if (prefs.contains("dontshowagain")) {
            final boolean flag = prefs.getBoolean("dontshowagain", false);
            if (flag) {
                return false;
            }
        }

        // Increment launch counter
        final long launch_count = prefs.getLong("launch_count", 0) + 1;
        editor.putLong("launch_count", launch_count);

        // Get date of first launch
        Long date_firstLaunch = prefs.getLong("date_firstlaunch", 0);
        if (date_firstLaunch == 0) {
            date_firstLaunch = System.currentTimeMillis();
            editor.putLong("date_firstlaunch", date_firstLaunch);
        }

        editor.commit();

        // Wait at least n days before opening
        if (launch_count >= LAUNCHES_UNTIL_PROMPT) {
            if (System.currentTimeMillis() >= date_firstLaunch
                    + (DAYS_UNTIL_PROMPT * 24 * 60 * 60 * 1000)) {
                showRateDialog(mContext, editor);
                return true;
            }
        }

        return false;

    }

    public static void showRateDialog(final Context mContext,
                                      final SharedPreferences.Editor editor) {

        final AlertDialog.Builder aBuilder = new AlertDialog.Builder(mContext);
        aBuilder.setTitle("Rate " + mContext.getString(R.string.app_name));
        aBuilder.setIcon(R.drawable.info);
        aBuilder.setMessage("If you enjoy using "
                + mContext.getString(R.string.app_name)
                + ", Please take a moment to rate it. Thanks for your support!");

        aBuilder.setPositiveButton("Rate now!", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(final DialogInterface dialog, final int which) {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri
                        .parse("https://play.google.com/store/apps/details?id="
                                + mContext.getPackageName())));
                dialog.dismiss();
            }

        });

        aBuilder.setNeutralButton("Later",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(final DialogInterface dialog,
                                        final int which) {

                        dialog.dismiss();

                    }

                });

        aBuilder.setNegativeButton("Don't show again",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(final DialogInterface dialog,
                                        final int which) {

                        if (editor != null) {
                            editor.putBoolean("dontshowagain", true);
                            editor.commit();
                        }
                        dialog.dismiss();

                    }

                });

        aBuilder.show();

    }

	/*
     * standalone
	 */

    public static void showRateDialog(final Context mContext) {

        final AlertDialog.Builder aBuilder = new AlertDialog.Builder(mContext);
        aBuilder.setTitle("Rate " + mContext.getString(R.string.app_name));
        aBuilder.setIcon(mContext.getResources().getDrawable(R.drawable.info));
        aBuilder.setMessage("If you enjoy using "
                + mContext.getString(R.string.app_name)
                + ", Please take a moment to rate it. Thanks for your support!");

        aBuilder.setPositiveButton("Rate now!", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(final DialogInterface dialog, final int which) {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri
                        .parse("https://play.google.com/store/apps/details?id="
                                + mContext.getPackageName())));
                dialog.dismiss();
            }

        });

        aBuilder.setNeutralButton("Later",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(final DialogInterface dialog,
                                        final int which) {

                        dialog.dismiss();

                    }

                });

        aBuilder.show();

    }

}
