package com.example.attendancesystem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdminAttendanceHistoryAdapter extends RecyclerView.Adapter<AdminAttendanceHistoryAdapter.RCViewHolder>{

    Context context;
    ArrayList<AttendanceModel> userArrayList;

    public AdminAttendanceHistoryAdapter(Context context, ArrayList<AttendanceModel> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public RCViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_history_attendance, parent, false);
        return new RCViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RCViewHolder holder, int position) {
        AttendanceModel user = userArrayList.get(position);
        Log.d("User",String.valueOf(user.getDate()));
        holder.tvDate.setText(String.valueOf(user.getDate()));
        holder.tvHours.setText(String.valueOf(user.getTotalHours()));
        holder.tvTime.setText(String.valueOf(user.getTime()));

//        holder.rc_name.setText(user.getName());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context,MoreDetailActivity.class);
//                intent.putExtra("userClass", user);
//                intent.putExtra("position", holder.getAdapterPosition());
//
//                ((Activity) context).startActivityForResult(intent, 101);
//            }
//        });

    }
    @Override
    public int getItemCount() {
        return userArrayList.size();
    }


    public class RCViewHolder extends RecyclerView.ViewHolder {

        TextView tvDate, tvHours, tvTime;

        public RCViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tvDate);
            tvHours = itemView.findViewById(R.id.tvHours);
            tvTime = itemView.findViewById(R.id.tvTime);
        }
    }


}
