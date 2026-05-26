package com.example.attendance_system;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdminAttendanceHistoryAdapter extends
        RecyclerView.Adapter<AdminAttendanceHistoryAdapter.AHViewHolder>{

    Context context;
    ArrayList<TimeDurationModel> userArrayList;

    public AdminAttendanceHistoryAdapter(Context context,
                                         ArrayList<TimeDurationModel> userArrayList) {

        this.context = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public AHViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                           int viewType) {

        View view = LayoutInflater.from(context).inflate(
                R.layout.item_history_layout,
                parent,
                false
        );

        return new AHViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AHViewHolder holder,
                                 int position) {

        TimeDurationModel user = userArrayList.get(position);

        holder.tvDate.setText(user.getDate());

        holder.tvHours.setText(user.getTotalHours());

        holder.tvTime.setText(user.getTime());

        holder.itemView.setOnClickListener(view -> {

            // click on timing left
            Intent intent = new Intent(
                    context,
                    TakingAttendanceActivity.class
            );

            context.startActivity(intent);


            Toast.makeText(
                    context,
                    "Reached",
                    Toast.LENGTH_SHORT
            ).show();

        });
    }

    @Override
    public int getItemCount() {

        return userArrayList.size();
    }

    public static class AHViewHolder extends RecyclerView.ViewHolder {

        TextView tvDate, tvHours, tvTime;

        public AHViewHolder(@NonNull View itemView) {

            super(itemView);

            tvDate = itemView.findViewById(R.id.tvDate);

            tvHours = itemView.findViewById(R.id.tvHours);

            tvTime = itemView.findViewById(R.id.tvTime);
        }
    }
}