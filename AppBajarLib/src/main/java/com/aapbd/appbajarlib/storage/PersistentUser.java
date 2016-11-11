package com.aapbd.appbajarlib.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PersistentUser {

    private static final String USERNAME = "username";
    private static final String USERIMAGEURL = "USERIMAGEURL";

    private static final String FULLNAME = "fullname";

    private static final String USERID = "uid";
    private static final String USEREMAIL = "useremail";
    private static final String ACCESSTOKEN = "accesstoken";

    private static final String USERDETAILS = "userdetails";
    private static final String PASSWORD = "password";
    private static final String PREFS_FILE_NAME = "AppPreferences";

    public static String getAccessToken(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(ACCESSTOKEN, "");
    }

    public static String getPassword(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(PASSWORD, "");
    }

    public static String getUserID(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(USERID, "0");
    }


    public static String getUserImage(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(USERIMAGEURL, "");
    }

    /*
    * Langauge
    */
    public static void setUserImage(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(USERIMAGEURL, data);
        editor.commit();
    }
    /*
     * Langauge
     */
    public static void setPassword(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(PASSWORD, data);
        editor.commit();
    }

    /*
     * set access token
     */
    public static void setAccessToken(final Context ctx, final String token) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(ACCESSTOKEN, token);
        editor.commit();
    }

    /*
     * Langauge
     */
    public static void setUserID(final Context ctx, final String id) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(USERID, id);
        editor.commit();
    }

    public static String getUserName(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(USERNAME, "");
    }

    public static String getFullName(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(FULLNAME, "");
    }
    public static String getUserEmail(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(USEREMAIL, "");
    }

    public static String getUserDetails(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(USERDETAILS, "");
    }

    /*
     * Langauge
     */
    public static void setUserEmail(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(USEREMAIL, data);
        editor.commit();
    }

    /*
     * Langauge
     */
    public static void setUserName(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(USERNAME, data);
        editor.commit();
    }

    /*
   * Langauge
   */
    public static void setFullname(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(FULLNAME, data);
        editor.commit();
    }
    /*
     * Langauge
     */
    public static void setUserDetails(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(USERDETAILS, data);
        editor.commit();
    }

    public static void logOut(Context c) {

        final SharedPreferences prefs = c.getSharedPreferences(PREFS_FILE_NAME,
                Context.MODE_PRIVATE);
        prefs.edit().putBoolean("LOGIN", false).commit();

    }

    public static void setLogin(Context c) {

        final SharedPreferences prefs = c.getSharedPreferences(PREFS_FILE_NAME,
                Context.MODE_PRIVATE);
        prefs.edit().putBoolean("LOGIN", true).commit();
    }

    public static boolean isLogged(Context c) {

        final SharedPreferences prefs = c.getSharedPreferences(PREFS_FILE_NAME,
                Context.MODE_PRIVATE);

        return prefs.getBoolean("LOGIN", false);
    }

    public static void resetAllData(Context c) {

        setUserName(c, "");
        setFullname(c, "");
        setUserID(c, "");
        setUserEmail(c, "");
        setUserDetails(c, "");
        setAccessToken(c, "");
        setPassword(c,"");

    }

}
