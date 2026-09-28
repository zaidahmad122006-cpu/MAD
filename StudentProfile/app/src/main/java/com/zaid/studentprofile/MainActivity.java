package com.zaid.studentprofile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView studImage;
    Button btnImage;
    Button btnRead;
    Button btnSave;
    Button btnClear;
    TextView txtName;
    TextView txtRoll;
    TextView txtDesc;
    Uri slectedImageUri;
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

        btnImage = findViewById(R.id.btnImage);
        btnRead = findViewById(R.id.btnRead);
        btnSave = findViewById(R.id.btnSave);
        btnClear = findViewById(R.id.btnClear);

        txtDesc = findViewById(R.id.txtDesc);
        txtName = findViewById(R.id.txtName);
        txtRoll = findViewById(R.id.txtRoll);

        studImage = findViewById(R.id.studImage);

        btnImage.setOnClickListener(v ->{
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/x");
            startActivityForResult(intent, 100);
        });

        btnSave.setOnClickListener(v ->{
            String name = txtName.getText().toString();
            String roll = txtRoll.getText().toString();

            if(name.isEmpty() || roll.isEmpty())
            {
                Toast.makeText(this, "Please enter the Name: ",Toast.LENGTH_SHORT).show();
            }

            else
            {
                Toast.makeText(this, "Data is Invalid!",Toast.LENGTH_SHORT).show();
            }
        });

    }
}