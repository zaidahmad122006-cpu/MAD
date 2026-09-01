package com.zaid.addition;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView valn;

    Button btnsum;
    private int n;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        valn = findViewById(R.id.valn);
        btnsum = findViewById(R.id.btnsum);

        btnsum.setOnClickListener(V ->
        {
            if (n <=0)
            {
                Toast.makeText(
                        MainActivity.this,
                        getString(R.string.error_postive_n),
                        Toast.LENGTH_SHORT

                ).show();
                return;
            }
        });
        //Calculate


        Intent intent = new Intent(
                MainActivity.this,
                ResultActivity.class
        );


    }
}