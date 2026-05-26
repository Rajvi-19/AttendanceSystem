package com.example.attendance_system;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ViewHistoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdminAttendanceHistoryAdapter adapter;
    static ArrayList<TimeDurationModel> list;
    FloatingActionButton fab_addBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);
        recyclerView = findViewById(R.id.recyclerAttendance);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        adapter = new AdminAttendanceHistoryAdapter(this, list);

        recyclerView.setAdapter(adapter);

        loadDummyData();

        adapter.notifyDataSetChanged();

        fab_addBtn = findViewById(R.id.fab_add);
        fab_addBtn.setOnClickListener(view -> {

            Intent intent = new Intent(
                    ViewHistoryActivity.this,
                    AddNewAttendanceActivity.class
            );

            startActivityForResult(intent, 101);
            Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();

        });



    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101 && resultCode == RESULT_OK) {

            TimeDurationModel model =
                    (TimeDurationModel) data.getSerializableExtra(
                            "attendanceData"
                    );

            list.add(model);

            adapter.notifyDataSetChanged();
        }
    }

    private void loadDummyData() {

        list.add(new TimeDurationModel(
                "29 January 2026",
                "02:00 Hrs",
                "09:00 AM - 11:00 AM"
        ));

        list.add(new TimeDurationModel(
                "28 January 2026",
                "03:30 Hrs",
                "09:30 AM - 01:00 PM"
        ));

        list.add(new TimeDurationModel(
                "27 January 2026",
                "00:00 Hrs",
                "09:30 AM - 01:00 PM"
        ));

        list.add(new TimeDurationModel(
                "26 January 2026",
                "00:00 Hrs",
                "09:30 AM - 01:00 PM"
        ));

        list.add(new TimeDurationModel(
                "25 January 2026",
                "00:00 Hrs",
                "09:30 AM - 01:00 PM"
        ));

        list.add(new TimeDurationModel(
                "24 January 2026",
                "00:00 Hrs",
                "09:30 AM - 01:00 PM"
        ));

        list.add(new TimeDurationModel(
                "23 January 2026",
                "00:00 Hrs",
                "09:30 AM - 01:00 PM"
        ));

        list.add(new TimeDurationModel(
                "22 January 2026",
                "00:00 Hrs",
                "09:30 AM - 01:00 PM"
        ));

    }

}