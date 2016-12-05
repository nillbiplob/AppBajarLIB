package com.aapbd.appbajarlib.nagivation;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;
import android.widget.Toast;

import java.io.File;

public class ShareUtils {

	/*
     * open mail
	 */

    public static void byMail(Context context, String[] mailTo, String subject,
                              String content) {

        try {
            final Intent emailIntent = new Intent(
                    Intent.ACTION_SEND);

            emailIntent.setType("plain/text");

            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, mailTo);

            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, content);
            context.startActivity(emailIntent);
        } catch (final Exception e) {
            // TODO: handle exception
        }
    }

	/*
	 * open mail
	 */

    public static void byMailWithImageFile(Context context, String[] mailTo,
                                           String subject, String content, File f) {

        try {
            final Intent emailIntent = new Intent(
                    android.content.Intent.ACTION_SEND);

            emailIntent.setType("application/image");

            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, mailTo);

            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, content);

            if (f != null) {
                emailIntent.putExtra(Intent.EXTRA_STREAM,
                        Uri.parse("file://" + f.getAbsolutePath()));

            }

            context.startActivity(emailIntent);
        } catch (final Exception e) {
            // TODO: handle exception
        }
    }

	/*
	 * open all sharable option
	 */

    public static void toTextToAll(Context context, String text) {

        try {

            final Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, text);

            context.startActivity(Intent.createChooser(sharingIntent,
                    "Share using"));

        } catch (final Exception e) {
            // TODO: handle exception
        }
    }

	/*
	 * open all sharable option
	 */

    public static void shareImageToAll(Context con, File f) {

        try {

            final Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("image/jpeg");

            share.putExtra(Intent.EXTRA_STREAM,
                    Uri.parse("file:///" + f.getAbsolutePath()));
            con.startActivity(Intent.createChooser(share, "Share Image"));

        } catch (final Exception e) {
            // TODO: handle exception
        }
    }

    public static void mmsImageToAll(Context con, String text, File f) {

        try {

            final Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setClassName("com.android.mms",
                    "com.android.mms.ui.ComposeMessageActivity");
            sendIntent.putExtra("sms_body", text);
            sendIntent.putExtra(Intent.EXTRA_STREAM,
                    Uri.parse("file://" + f.getAbsolutePath()));
            sendIntent.setType("image/*");
            con.startActivity(sendIntent);

        } catch (final ActivityNotFoundException e) {
            // TODO: handle exception

            final Intent intent = new Intent(Intent.ACTION_SENDTO,
                    Uri.parse("mmsto:"));
            intent.putExtra("sms_body", text);
            intent.putExtra(Intent.EXTRA_STREAM,
                    Uri.parse("file://" + f.getAbsolutePath()));
            intent.setType("image/*");

            con.startActivity(intent);

        } catch (final Exception e) {
            // TODO: handle exception

            Toast.makeText(con, "No client is installed", 500).show();
        }
    }

	/*
	 * Share by SMS
	 */

    @SuppressLint("NewApi")
    public static void shareBySMS(Context con, String text) {

        try {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) // At least
            // KitKat
            {
                final String defaultSmsPackageName = Telephony.Sms
                        .getDefaultSmsPackage(con); // Need to change the build
                // to API 19

                final Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT, text);

                if (defaultSmsPackageName != null)// Can be null in case that
                // there is no default, then
                // the user would be able to
                // choose any app that
                // support this intent.
                {
                    sendIntent.setPackage(defaultSmsPackageName);
                }
                con.startActivity(sendIntent);

            } else // For early versions, do what worked for you before.
            {
                final Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:"));
                sendIntent.putExtra("sms_body", text);
                con.startActivity(sendIntent);
            }

        } catch (final Exception e) {
            // TODO: handle exception
        }
    }

}
