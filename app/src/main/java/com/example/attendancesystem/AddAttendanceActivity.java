package com.example.attendancesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AddAttendanceActivity extends AppCompatActivity {
    CalendarView calendarView;
    Spinner spStartHour, spStartMin, spEndHour, spEndMin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attendance);


        calendarView = findViewById(R.id.calendarView);
        final String[] selectedDate = new String[1];
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        selectedDate[0] = sdf.format(calendar.getTime());
    });

        spStartHour = findViewById(R.id.spStartHour);
        spStartMin = findViewById(R.id.spStartMin);
        spEndHour = findViewById(R.id.spEndHour);
        spEndMin = findViewById(R.id.spEndMin);

        setupTimeSpinners();


        Button btnAttendance = findViewById(R.id.btnAttendance);

        btnAttendance.setOnClickListener(v -> {

            String startHour = spStartHour.getSelectedItem().toString();
            String startMin = spStartMin.getSelectedItem().toString();
            String endHour = spEndHour.getSelectedItem().toString();
            String endMin = spEndMin.getSelectedItem().toString();

            if (startHour.equals(endHour) && startMin.equals(endMin)) {
                Toast.makeText(this, "Start & End time cannot be same", Toast.LENGTH_SHORT).show();
                return;
            }


            String timeSlot = startHour + ":" + startMin
                    + " - " + endHour + ":" + endMin;

            Toast.makeText(this, timeSlot, Toast.LENGTH_SHORT).show();

            // Later: save this to DB / pass to RecyclerView
        });



    }

    private void setupTimeSpinners() {

        // Hours: 01 - 12
        ArrayList<String> hours = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            hours.add(String.format(Locale.getDefault(), "%02d", i));
        }

        // Minutes: 00, 15, 30, 45
        ArrayList<String> minutes = new ArrayList<>();
        minutes.add("00");
        minutes.add("15");
        minutes.add("30");
        minutes.add("45");

        ArrayAdapter<String> hourAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, hours);
        hourAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> minAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, minutes);
        minAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spStartHour.setAdapter(hourAdapter);
        spEndHour.setAdapter(hourAdapter);

        spStartMin.setAdapter(minAdapter);
        spEndMin.setAdapter(minAdapter);
    }



}