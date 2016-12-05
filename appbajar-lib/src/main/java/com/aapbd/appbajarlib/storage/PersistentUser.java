package com.aapbd.appbajarlib.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PersistentUser {

    /*
    Two common method singleTone method
     */
    private static PersistentUser ourInstance = new PersistentUser();

    public static PersistentUser getInstance() {
        return ourInstance;
    }



    private static final String USERNAME = "username";
    private static final String PHONENUMBER = "phonenumber";

    private static final String USERIMAGEURL = "USERIMAGEURL";

    private static final String FULLNAME = "fullname";

    private static final String USERID = "uid";
    private static final String USEREMAIL = "useremail";
    private static final String ACCESSTOKEN = "accesstoken";

    private static final String USERDETAILS = "userdetails";
    private static final String PASSWORD = "password";
    private static final String PREFS_FILE_NAME = "AppPreferences";

    public  String getPhoneNumber(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(PHONENUMBER, "");
    }

    public  String getAccessToken(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(ACCESSTOKEN, "");
    }

    public  String getPassword(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(PASSWORD, "");
    }

    public  String getUserID(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(USERID, "0");
    }


    public  String getUserImage(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(USERIMAGEURL, "");
    }
/*
    * Langauge
    */
    public  void setPhonenumber(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(PHONENUMBER, data);
        editor.commit();
    }


    /*
    * Langauge
    */
    public  void setUserImage(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(USERIMAGEURL, data);
        editor.commit();
    }
    /*
     * Langauge
     */
    public  void setPassword(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(PASSWORD, data);
        editor.commit();
    }

    /*
     * set access token
     */
    public  void setAccessToken(final Context ctx, final String token) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(ACCESSTOKEN, token);
        editor.commit();
    }

    /*
     * Langauge
     */
    public  void setUserID(final Context ctx, final String id) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(USERID, id);
        editor.commit();
    }

    public  String getUserName(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(USERNAME, "");
    }

    public  String getFullName(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(FULLNAME, "");
    }
    public  String getUserEmail(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(USEREMAIL, "");
    }

    public  String getUserDetails(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(USERDETAILS, "");
    }

    /*
     * Langauge
     */
    public  void setUserEmail(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(USEREMAIL, data);
        editor.commit();
    }

    /*
     * Langauge
     */
    public  void setUserName(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(USERNAME, data);
        editor.commit();
    }

    /*
   * Langauge
   */
    public  void setFullname(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(FULLNAME, data);
        editor.commit();
    }
    /*
     * Langauge
     */
    public  void setUserDetails(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(USERDETAILS, data);
        editor.commit();
    }

    public  void logOut(Context c) {

        final SharedPreferences prefs = c.getSharedPreferences(PREFS_FILE_NAME,
                Context.MODE_PRIVATE);
        prefs.edit().putBoolean("LOGIN", false).commit();

    }

    public  void setLogin(Context c) {

        final SharedPreferences prefs = c.getSharedPreferences(PREFS_FILE_NAME,
                Context.MODE_PRIVATE);
        prefs.edit().putBoolean("LOGIN", true).commit();
    }

    public  boolean isLogged(Context c) {

        final SharedPreferences prefs = c.getSharedPreferences(PREFS_FILE_NAME,
                Context.MODE_PRIVATE);

        return prefs.getBoolean("LOGIN", false);
    }

    public void resetAllData(Context c) {

        setUserName(c, "");
        setFullname(c, "");
        setUserID(c, "");
        setUserEmail(c, "");
        setUserDetails(c, "");
        setAccessToken(c, "");
        setPassword(c,"");
        setPhonenumber(c,"");

    }

}
