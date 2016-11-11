package com.aapbd.appbajarlibsample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aapbd.appbajarlib.encryption.KeyHashManager;
import com.aapbd.appbajarlib.print.Print;

public class MainActivity extends AppCompatActivity {

    private Context con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        con=this;


        /*
        print SHA-1 of your debug/release key
         */

        String sha= KeyHashManager.getKeyHash(con);

        /*
        print at log
         */


        Print.message("Device SHA is ", sha);
    }
}
