package com.example.attendancesystem;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class AdminAttendanceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_attendance);

        recyclerView = findViewById(R.id.recyclerView);
        btnSave = findViewById(R.id.btnSave);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> students = Arrays.asList(
                "Aman", "Riya", "Sahil", "Neha"
        );

        AdminAttendanceAdapter adapter =
                new AdminAttendanceAdapter(students);
        recyclerView.setAdapter(adapter);

        btnSave.setOnClickListener(v -> {
            Toast.makeText(this,
                    "Attendance Saved", Toast.LENGTH_SHORT).show();
        });
    }
}
