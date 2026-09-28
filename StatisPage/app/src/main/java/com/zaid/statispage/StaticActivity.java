package com.zaid.statispage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class StaticActivity extends AppCompatActivity {
    WebView webView;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        String s = "<html>" +
                "<body>" +
                "<h1>Welcome to NMIMS</h1>" +
                "<p>It's a Static Web HTML Content</p>" +
                "<p>My name is Zaid Ahmad</p>" +

                "</body>" +
                "</html>";

        webView.loadData (s,"text/html","UTF-8");

    }
}
