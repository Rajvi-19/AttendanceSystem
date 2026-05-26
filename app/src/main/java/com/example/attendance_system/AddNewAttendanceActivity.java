package com.example.attendance_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AddNewAttendanceActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    CalendarView calendarView;
    Spinner spStartHour, spStartMin, spEndHour, spEndMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_attendance);

        calendarView = findViewById(R.id.calendarView);

        final String[] selectedDate = new String[1];

        Calendar currentCalendar = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat(
                "dd MMMM yyyy",
                Locale.getDefault()
        );

        selectedDate[0] = sdf.format(currentCalendar.getTime());

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {

            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, dayOfMonth);
            SimpleDateFormat sf = new SimpleDateFormat(
                    "dd MMMM yyyy",
                    Locale.getDefault()
            );
            selectedDate[0] = sf.format(calendar.getTime());
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
            String totalHours = getTotalHour(startHour, startMin, endHour, endMin);

            Toast.makeText(this, timeSlot, Toast.LENGTH_SHORT).show();



            TimeDurationModel model = new TimeDurationModel(
                    selectedDate[0],
                    totalHours,
                    timeSlot
            );

            Intent intent = new Intent();

            intent.putExtra("attendanceData", model);

            setResult(RESULT_OK, intent);

            finish();

            // Later: save this to DB / pass to RecyclerView
        });



    }

    private void setupTimeSpinners() {

        // Hours Placeholder + 01 - 12
        ArrayList<String> hours = new ArrayList<>();



        for (int i = 1; i <= 12; i++) {
            hours.add(String.format(Locale.getDefault(), "%02d", i));
        }

        // Minutes Placeholder + Values
        ArrayList<String> minutes = new ArrayList<>();

        minutes.add("00");
        minutes.add("15");
        minutes.add("30");
        minutes.add("45");

        ArrayAdapter<String> hourAdapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        hours
                );


        hourAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );



        ArrayAdapter<String> minAdapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        minutes
                );

        minAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spStartHour.setAdapter(hourAdapter);
        spStartMin.setAdapter(minAdapter);
        spEndHour.setAdapter(hourAdapter);
        spEndMin.setAdapter(minAdapter);
    }


    private String getTotalHour(String startHour,String startMin, String endHour, String endMin){
        int startH = Integer.parseInt(startHour);
        int startM = Integer.parseInt(startMin);

        int endH = Integer.parseInt(endHour);
        int endM = Integer.parseInt(endMin);

// Convert into total minutes
        int startTotal = (startH * 60) + startM;
        int endTotal = (endH * 60) + endM;

// Difference
        if (endTotal < startTotal) {
            endTotal += 12 * 60;
        }

        int diff = endTotal - startTotal;

// Hours & Minutes
        int hrs = diff / 60;
        int mins = diff % 60;

// Final Format
        String totalHours = String.format(
                "%02d:%02d Hrs",
                hrs,
                mins
        );

        return totalHours;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // show the selected time
        String selectedItem = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}