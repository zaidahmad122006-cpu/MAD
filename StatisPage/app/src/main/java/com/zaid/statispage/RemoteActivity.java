package com.zaid.statispage;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RemoteActivity extends AppCompatActivity {
    TextView entUrl;
    Button btnDisplay;
    WebView webView;

    protected void onCreate(Bundle savedInstanceState) {
        entUrl = findViewById(R.id.entUrl);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);

        btnDisplay.setOnClickListener(v ->{
            String url = entUrl.getText().toString().trim();
            if (!url.startsWith("http://")&&)
        });
        webview.loadUrl()

    }
}
