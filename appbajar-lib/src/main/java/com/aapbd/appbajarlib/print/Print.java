package com.aapbd.appbajarlib.print;

import android.util.Log;

public class Print {


     private static Print instance;

     private boolean shouldPrint=true;

     public static Print getInstance ()
     {
         if(instance==null)
             instance=new Print();

         return instance;
     }

    private Print() {
    }


    public boolean isShouldPrint() {
        return shouldPrint;
    }

    public void setShouldPrint(boolean shouldPrint) {
        this.shouldPrint = shouldPrint;
    }

    public void printError(String message) {
        printError(null, message);
    }

    public  void printError(String TAG, String message)
    {

        if(!shouldPrint)
            return;

        if(TAG==null)
        {

            Log.e("Error :", message + "");
        }else
        {
            Log.e(TAG + "", message + "");
        }

    }

    public static void message(String message) {


        Log.e("Message is:", message + "");

    }

    public static void message(String TAG, String message)
    {
        Log.e(TAG + "", message + "");
    }

}
