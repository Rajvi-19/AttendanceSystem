package com.example.attendancesystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllDaysAttendanceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdminAttendanceHistoryAdapter adapter;
    ArrayList<AttendanceModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_days_attendance);

        recyclerView = findViewById(R.id.recyclerAttendance);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new AdminAttendanceHistoryAdapter(list);
        recyclerView.setAdapter(adapter);

        loadDummyData(); // for now
    }

    private void loadDummyData() {

        list.add(new AttendanceModel(
                "29 January 2026",
                "02:00 Hrs",
                "09:00 AM - 11:00 AM"
        ));

        list.add(new AttendanceModel(
                "28 January 2026",
                "03:30 Hrs",
                "09:30 AM - 01:00 PM"
        ));

        list.add(new AttendanceModel(
                "27 January 2026",
                "00:00 Hrs",
                "09:30 AM - 01:00 PM"
        ));

        list.add(new AttendanceModel(
                "26 January 2026",
                "00:00 Hrs",
                "09:30 AM - 01:00 PM"
        ));

        list.add(new AttendanceModel(
                "25 January 2026",
                "00:00 Hrs",
                "09:30 AM - 01:00 PM"
        ));

        list.add(new AttendanceModel(
                "24 January 2026",
                "00:00 Hrs",
                "09:30 AM - 01:00 PM"
        ));

        list.add(new AttendanceModel(
                "23 January 2026",
                "00:00 Hrs",
                "09:30 AM - 01:00 PM"
        ));

        list.add(new AttendanceModel(
                "22 January 2026",
                "00:00 Hrs",
                "09:30 AM - 01:00 PM"
        ));

        adapter.notifyDataSetChanged();
    }

}