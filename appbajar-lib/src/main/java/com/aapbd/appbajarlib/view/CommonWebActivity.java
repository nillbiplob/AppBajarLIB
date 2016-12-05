package com.aapbd.appbajarlib.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.aapbd.appbajarlib.R;
import com.aapbd.appbajarlib.notification.BusyDialog;


public class CommonWebActivity extends Activity {
    public Context con;
    private WebView web;
    private TextView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.commonweb);
        con = this;
        titleView = (TextView) findViewById(R.id.commonwebtitle);

        if (getIntent().hasExtra("title")) {
            titleView.setText(getIntent().getStringExtra("title"));
        }

        web = (WebView) findViewById(R.id.tutorialwebview);
        web = WebViewFormatter.formatWebView(web, true);
        web.setWebViewClient(new MyWebViewClient());

        if (getIntent().hasExtra("url")) {
            web.loadUrl(getIntent().getStringExtra("url"));
        }

    }

    public void setBack(View v) {
        finish();

    }

    private class MyWebViewClient extends WebViewClient {

       BusyDialog busyNow = new BusyDialog(con, true);

        @Override
        public void onPageFinished(final WebView view, final String url) {
            Log.d("web status", "onPageFinished");
            if (busyNow != null) {
                busyNow.dismis();
            }
            // progressBar.setVisibility(View.GONE);

            // This call inject JavaScript into the page which just finished
            // loading.
            web.loadUrl("javascript:window.HTMLOUT.showHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');");
            // adjust prev/next buttons, only if history is available

        }

        @Override
        public void onPageStarted(final WebView view, final String url,
                                  final Bitmap favicon) {
            Log.d("web status", "onPageStarted");

            if (busyNow != null) {
                busyNow.show();
            }

        }

        @Override
        public boolean shouldOverrideUrlLoading(final WebView view,
                                                final String url) {

            Log.e("clicked data is ", url + "");

            if (url.startsWith("http")) {
                view.loadUrl(url);
            } else {
                try {
                    final Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(url));
                    startActivity(intent);
                } catch (Exception e) {

                }
            }

            return true;


        }

    }

}
