package com.example.attendancesystem;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminAttendanceAdapter
        extends RecyclerView.Adapter<AdminAttendanceAdapter.ViewHolder> {

    List<String> students;
    Map<Integer, String> attendanceMap = new HashMap<>();
    Button btnP, btnA, btnL;

    public AdminAttendanceAdapter(List<String> students) {
        this.students = students;
        for (int i = 0; i < students.size(); i++) {
            attendanceMap.put(i, "P"); // default Present
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student_attendance, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder h, int pos) {
        h.tvName.setText(students.get(pos));

        h.btnP.setOnClickListener(v -> changeColor(v));
        h.btnA.setOnClickListener(v -> changeColor(v));
        h.btnL.setOnClickListener(v -> changeColor(v));
    }


    void changeColor(View view){

        Drawable bg = view.getBackground();

        // If already selected → unselect (turn gray)
        if (view.getTag() != null && (boolean) view.getTag()) {
            bg.setColorFilter(
                    ContextCompat.getColor(view.getContext(), R.color.default_gray),
                    PorterDuff.Mode.SRC_IN
            );
            view.setTag(false);
            return;
        }
        // Change clicked button color
        if (view.getId() == R.id.btnP) {
            bg.setColorFilter(
                    ContextCompat.getColor(view.getContext(), R.color.present_green),
                    PorterDuff.Mode.SRC_IN
            );// Green
        }
        else if (view.getId() == R.id.btnA) {
            bg.setColorFilter(
                    ContextCompat.getColor(view.getContext(), R.color.absent_red),
                    PorterDuff.Mode.SRC_IN
            );// Red
        }
        else if (view.getId() == R.id.btnL) {
            bg.setColorFilter(
                    ContextCompat.getColor(view.getContext(), R.color.late_orange),
                    PorterDuff.Mode.SRC_IN
            );// Orange
        }

        // Mark as selected
        view.setTag(true);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        Button btnP, btnA, btnL;

        ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            btnP = itemView.findViewById(R.id.btnP);
            btnA = itemView.findViewById(R.id.btnA);
            btnL = itemView.findViewById(R.id.btnL);


        }
    }
}
