package com.samnadya.kumpulanappdasar;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebView_atuh extends AppCompatActivity {

    WebView webView;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        webView = (WebView) findViewById(R.id.webView);
        pb = (ProgressBar) findViewById(R.id.progressBar);
        //untuk mendapatkan url
        webView.loadUrl("http://detik.com");
//        webView.getSettings().supportMultipleWindows();
//        webView.getSettings().setSupportMultipleWindows(false);
////        webView.getSettings().getAllowContentAccess();
//        webView.getSettings().setDomStorageEnabled(true);
//        webView.getSettings().setLoadWithOverviewMode(true);
//        webView.getSettings().setSupportMultipleWindows(true);
//        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        //berfungsi untuk mendapatkan client responnya ke komponen webview
        webView.setWebViewClient(new dede());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public class dede extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            pb.setVisibility(view.INVISIBLE);
        }
    }

}
