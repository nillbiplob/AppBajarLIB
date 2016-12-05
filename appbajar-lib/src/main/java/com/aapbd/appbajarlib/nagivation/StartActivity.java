package com.aapbd.appbajarlib.nagivation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.aapbd.appbajarlib.network.KeyValue;

import java.io.File;
import java.util.Vector;

public class StartActivity {

    public static void toHome(Context context, Class<?> home) {
        // TODO Auto-generated method stub
        try {

            final Intent intent = new Intent(context, home);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        } catch (final Exception e) {

        }

    }

    public static void toActivity(Context context, Class<?> Destination) {
        // TODO Auto-generated method stub

        try {

            final Intent intent = new Intent(context, Destination);
            context.startActivity(intent);
        } catch (final Exception e) {

        }

    }

    public static void toActivityWithDataSet(Context context,
                                             Class<?> Destination, Vector<KeyValue> datas) {
        // TODO Auto-generated method stub

        try {

            final Intent intent = new Intent(context, Destination);

            for (final KeyValue k : datas) {
                intent.putExtra(k.getKey(), k.getValue());
            }

            context.startActivity(intent);
        } catch (final Exception e) {

        }

    }

    public static void toActivityWithData(Context context,
                                          Class<?> Destination, KeyValue data) {
        // TODO Auto-generated method stub

        try {

            final Intent intent = new Intent(context, Destination);

            intent.putExtra(data.getKey(), data.getValue());

            context.startActivity(intent);
        } catch (final Exception e) {

        }

    }

    public static void toActivityWithFlag(Context context,
                                          Class<?> Destination, int flag) {
        // TODO Auto-generated method stub

        try {
            final Intent intent = new Intent(context, Destination);
            intent.setFlags(flag);
            context.startActivity(intent);
        } catch (final Exception e) {

        }

    }

	/*
     * open site
	 */

    public static void toebsite(Context context, String url) {
        try {
            final Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url
                    .trim()));

            context.startActivity(i);

        } catch (final Exception e) {

        }

    }

	/*
	 * open mail
	 */

    public static void toMail(Context context, String[] mailTo, String subject,
                              String content) {

        try {
            final Intent emailIntent = new Intent(
                    android.content.Intent.ACTION_SEND);

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

    public static void toMailWithImageFile(Context context, String mailTo,
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
}
