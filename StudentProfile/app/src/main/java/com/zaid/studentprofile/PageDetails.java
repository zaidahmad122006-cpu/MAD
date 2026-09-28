package com.zaid.studentprofile;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PageDetails extends AppCompatActivity {

    Button btnBack;
    TextView txtReadDesc;
    ImageView studImage2;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_details);

        btnBack = findViewById(R.id.btnBack);
        txtReadDesc = findViewById(R.id.txtReadDesc);
        studImage2 = findViewById(R.id.studImage2);


    };
}
