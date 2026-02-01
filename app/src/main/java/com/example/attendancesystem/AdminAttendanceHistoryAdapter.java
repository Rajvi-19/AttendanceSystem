package com.example.attendancesystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdminAttendanceHistoryAdapter extends RecyclerView.Adapter<AdminAttendanceHistoryAdapter.ViewHolder> {

        ArrayList<AttendanceModel> list;

public AdminAttendanceHistoryAdapter(ArrayList<AttendanceModel> list) {
        this.list = list;
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_history_attendance, parent, false);
        return new ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        AttendanceModel model = list.get(position);

        holder.tvDate.setText(model.date);
        holder.tvHours.setText(model.totalHours);
        holder.tvTime.setText(model.time);


        }

@Override
public int getItemCount() {
        return list.size();
        }

static class ViewHolder extends RecyclerView.ViewHolder {

    TextView tvDate, tvHours, tvTime, tvStatus;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        tvDate = itemView.findViewById(R.id.tvDate);
        tvHours = itemView.findViewById(R.id.tvHours);
        tvTime = itemView.findViewById(R.id.tvTime);
    }
}
}
