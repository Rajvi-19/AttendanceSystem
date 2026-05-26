package com.example.attendance_system;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TakingAttendanceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taking_attendance);

        recyclerView = findViewById(R.id.recyclerView);
        btnSave = findViewById(R.id.btnSave);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<StudentModel> students = new ArrayList<>();

        students.add(new StudentModel("Aman", "101"));
        students.add(new StudentModel("Riya", "102"));
        students.add(new StudentModel("Sany", "103"));
        students.add(new StudentModel("Neha", "104"));
        students.add(new StudentModel("abc", "105"));
        students.add(new StudentModel("xyz", "106"));
        students.add(new StudentModel("zap", "107"));

        StudentAttendanceAdapter adapter =
                new StudentAttendanceAdapter(
                        this,
                        students
                );

        recyclerView.setAdapter(adapter);

        btnSave.setOnClickListener(v -> {
            Toast.makeText(this,
                    "Attendance Saved", Toast.LENGTH_SHORT).show();
        });


        adapter.notifyDataSetChanged();

    }
}