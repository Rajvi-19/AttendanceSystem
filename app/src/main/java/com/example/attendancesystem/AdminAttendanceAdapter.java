package com.example.attendancesystem;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminAttendanceAdapter
        extends RecyclerView.Adapter<AdminAttendanceAdapter.ViewHolder> {

    List<String> students;
    Map<Integer, String> attendanceMap = new HashMap<>();

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

        h.btnP.setOnClickListener(v -> attendanceMap.put(pos, "P"));
        h.btnA.setOnClickListener(v -> attendanceMap.put(pos, "A"));
        h.btnL.setOnClickListener(v -> attendanceMap.put(pos, "L"));
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
