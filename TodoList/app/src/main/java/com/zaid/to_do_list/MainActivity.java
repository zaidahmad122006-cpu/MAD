package com.zaid.to_do_list;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

import kotlinx.coroutines.scheduling.Task;

@SuppressWarnings("unused")
public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    FloatingActionButton FloatingActionButton;
    ArrayList<Task> taskList;
    TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.title), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerview = findViewbyId(R.id.Recycler);
        FloatingActionButton = findViewById(R.id.FloatingActionButton);
        taskList = new ArrayList<>();
        adapter = new TaskAdapter(taskList);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);

        taskList.add(new Task("Study Android", false) {
            @Override
            public void run() {

            }
        });
        taskList.add(new Task("Play Games", false) {
            @Override
            public void run() {

            }
        });
        taskList.add(new Task("Sleep", false) {
            @Override
            public void run() {

            }
        });


    }

    private RecyclerView findViewbyId(int recycler) {
    }
}