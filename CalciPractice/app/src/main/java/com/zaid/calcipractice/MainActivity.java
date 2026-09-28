package com.zaid.calcipractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int sum;
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

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnMulti = findViewById(R.id.btnMulti);
        Button btnDiv = findViewById(R.id.btnDiv);
        Button btnClear = findViewById(R.id.btnClear);

        TextView num1 = findViewById(R.id.num1);
        TextView num2 = findViewById(R.id.num2);
        TextView Ans = findViewById(R.id.Ans);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1 = num1.getText().toString().trim();
                String s2 = num2.getText().toString().trim();

                if (s1.isEmpty() || s2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter both the numbers!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Double n1 = Double.parseDouble(s1);
                Double n2 = Double.parseDouble(s2);

                Ans.setText(String.valueOf(n1 + n2));
            }
        });

        btnSub.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = num1.getText().toString().trim();
                String s2 = num2.getText().toString().trim();
            }
        });
    }
}