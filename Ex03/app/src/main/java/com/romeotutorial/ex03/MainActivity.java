package com.romeotutorial.ex03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = (WebView)findViewById(R.id.web);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("file:///android_asset/dada.html");
    }
}
