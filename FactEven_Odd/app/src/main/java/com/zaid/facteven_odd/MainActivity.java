package com.zaid.facteven_odd; // Change this to your actual package name

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare views with matching types
    private TextView title, Result;
    private EditText Num;
    private Button btnFact, btnOE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views using the exact IDs
        title = findViewById(R.id.title);
        Num = findViewById(R.id.Num);
        btnFact = findViewById(R.id.btnFact);
        btnOE = findViewById(R.id.btnOE);
        Result = findViewById(R.id.Result);

        // Handle Factorial Button Click
        btnFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = Num.getText().toString().trim();
                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }

                int number = Integer.parseInt(input);
                if (number < 0) {
                    Result.setText("Factorial undefined for negative numbers");
                } else if (number > 12) {
                    // Prevents integer overflow for high values
                    Result.setText("Number too large (Max 12)");
                } else {
                    long factorial = calculateFactorial(number);
                    Result.setText("Factorial: " + factorial);
                }
            }
        });

        // Handle Odd/Even Button Click
        btnOE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = Num.getText().toString().trim();
                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }

                int number = Integer.parseInt(input);
                if (number % 2 == 0) {
                    Result.setText(number + " is Even");
                } else {
                    Result.setText(number + " is Odd");
                }
            }
        });
    }

    // Helper method to compute factorial
    private long calculateFactorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}