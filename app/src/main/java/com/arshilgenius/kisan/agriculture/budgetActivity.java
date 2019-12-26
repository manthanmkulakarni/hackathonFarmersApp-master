package com.arshilgenius.kisan.agriculture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class budgetActivity extends AppCompatActivity {

    WebView wb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        wb1=(WebView)findViewById(R.id.webview1);

        wb1.getSettings().setJavaScriptEnabled(true);
        wb1.loadUrl("https://fitness-e0935.firebaseapp.com");

    }
}
