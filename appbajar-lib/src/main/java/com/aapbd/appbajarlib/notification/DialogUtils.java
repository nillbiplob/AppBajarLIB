package com.aapbd.appbajarlib.notification;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;

public class DialogUtils {

    private static Toast toast;

    public static void show(Context context, String message) {
        if (message == null) {
            return;
        }
        if (toast == null && context != null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        }
        if (toast != null) {
            toast.setText(message);
            toast.show();
        }
    }

    public static ProgressDialog getProgressDialog(Context context,
                                                   String message) {
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(message);
        return progressDialog;
    }

    public static void showLong(Context context, String message) {
        if (message == null) {
            return;
        }
        if (toast == null && context != null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        }
        if (toast != null) {
            toast.setText(message);
            toast.show();
        }
    }

    public static Dialog createDialog(Context context, String titleId,
                                      String messageId, String buttonText1, String buttonText2,
                                      DialogInterface.OnClickListener positiveButtonListener,
                                      DialogInterface.OnClickListener negativeButtonListener) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(titleId);
        builder.setMessage(messageId);
        builder.setPositiveButton(buttonText1, positiveButtonListener);
        builder.setNegativeButton(buttonText2, negativeButtonListener);

        return builder.create();
    }


    public static Dialog createDialog(Context context, String titleId,
                                      String messageId, String buttonText1,
                                      DialogInterface.OnClickListener positiveButtonListener) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(titleId);
        builder.setMessage(messageId);
        builder.setPositiveButton(buttonText1, positiveButtonListener);

        return builder.create();
    }


    public static Dialog createDialog(Context context, String titleId,
                                      String messageId, View view, String buttonText1,
                                      String buttonText2,
                                      DialogInterface.OnClickListener positiveClickListener,
                                      DialogInterface.OnClickListener negativeClickListener) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(titleId);
        builder.setMessage(messageId);
        builder.setView(view);
        builder.setPositiveButton(buttonText1, positiveClickListener);
        builder.setNegativeButton(buttonText2, negativeClickListener);

        return builder.create();
    }
}