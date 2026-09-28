package com.zaid.greeting_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.zaid.greeting_app.R;

public class MainActivity extends AppCompatActivity {

    EditText nameInput;
    Button greetButton;
    TextView greetingText;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;

                });
        nameInput = findViewById(R.id.nameInput);
        greetButton = findViewById(R.id.greetButton);
        greetingText = findViewById(R.id.greetingText);

        greetButton.setOnClickListener(v -> {

            String name = nameInput.getText().toString().trim();

            if (name.isEmpty()) {
                greetingText.setText("Please enter your name");
            } else {
                greetingText.setText("Hello, " + name + "!");
            }

            greetButton.setOnClickListener(v -> finish());
        });
    }
}