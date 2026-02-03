package com.example.attendancesystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminSemSelectionActivity extends AppCompatActivity {

    Button nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sem_selection);

        nextBtn = findViewById(R.id.next_pg);
        nextBtn.setOnClickListener(view -> {

            // ** FORWARDING TO THE NEXT ATTENDANCE PAGE **
            Intent intent = new Intent(AdminSemSelectionActivity.this,AllDaysAttendanceActivity.class);
            startActivity(intent);
        });
    }
}