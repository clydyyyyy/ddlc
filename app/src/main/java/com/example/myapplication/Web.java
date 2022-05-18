package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web extends AppCompatActivity {

    private WebView webView;
    private MediaPlayer mplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        mplayer = MediaPlayer.create(Web.this,R.raw.web);
        mplayer.setLooping(true);
        mplayer.start();

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://doki-doki-literature-club.fandom.com/wiki/Doki_Doki_Literature_Club_Wiki");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else{
        super.onBackPressed();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mplayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mplayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mplayer.stop();
        mplayer.release();
    }
}