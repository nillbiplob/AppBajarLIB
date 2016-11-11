package com.aapbd.appbajarlib.display;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class KeyBoardManager {


    public static void openKeyBoard(Context con, final View v) {
        final InputMethodManager inputMethodManager = (InputMethodManager) con.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInputFromWindow(
                v.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED,
                0);

    }

    public static void closeKeyBoard(final Context con, final View v) {

        final InputMethodManager imm = (InputMethodManager) con.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

    }

}
