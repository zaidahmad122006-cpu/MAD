package com.zaid.age_calculator;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private LocalDate selectedDate = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // From your screenshot: Setup Edge-to-Edge display
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Apply window insets to prevent UI from hiding behind the status bar or navigation bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Link your UI components to the exact IDs
        EditText dobInput = findViewById(R.id.DOB);
        Button calcButton = findViewById(R.id.Calc);
        TextView resultText = findViewById(R.id.Result);

        // 2. Prevent keyboard from popping up on the EditText
        dobInput.setFocusable(false);
        dobInput.setClickable(true);

        // 3. Set up the Calendar Pop-up when the DOB field is clicked
        dobInput.setOnClickListener(v -> {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        // Save the selected date (Months are 0-indexed in Calendar, but 1-indexed in LocalDate)
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            selectedDate = LocalDate.of(selectedYear, selectedMonth + 1, selectedDay);
                        }

                        // Display it in the EditText
                        String formattedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        dobInput.setText(formattedDate);
                    }, year, month, day);

            // Prevent selecting future dates for a birthday
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            datePickerDialog.show();
        });

        // 4. Handle the Calculate Button Click
        calcButton.setOnClickListener(v -> {
            if (selectedDate == null) {
                Toast.makeText(MainActivity.this, "Please select your Date of Birth first!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Calculate the exact age using java.time.Period
            LocalDate today = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                today = LocalDate.now();
            }
            Period age = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                age = Period.between(selectedDate, today);
            }

            // Format the result nicely
            String finalResult = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                finalResult = age.getYears() + " Years, " + age.getMonths() + " Months, and " + age.getDays() + " Days";
            }
            resultText.setText(finalResult);
        });
    }
}