package com.example.attendance_system;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAttendanceAdapter extends
        RecyclerView.Adapter<StudentAttendanceAdapter.SHViewHolder> {

    Context context;

    ArrayList<StudentModel> studentList;

    public StudentAttendanceAdapter(Context context,
                                    ArrayList<StudentModel> studentList) {

        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public SHViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                           int viewType) {

        View view = LayoutInflater.from(context).inflate(
                R.layout.item_student_attendance_layout,
                parent,
                false
        );

        return new SHViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SHViewHolder holder,
                                 int position) {

        StudentModel student = studentList.get(position);

        holder.tvName.setText(student.getStudentName());

        holder.tvEnroll.setText(student.getEnrollmentNo());

        // PRESENT BUTTON

        holder.btnP.setOnClickListener(v -> {

            holder.btnP.setBackgroundTintList(
                    ColorStateList.valueOf(
                            ContextCompat.getColor(
                                    context,
                                    R.color.present_green
                            )
                    )
            );

            holder.btnA.setBackgroundTintList(
                    ColorStateList.valueOf(
                            ContextCompat.getColor(
                                    context,
                                    R.color.default_gray
                            )
                    )
            );

            holder.btnL.setBackgroundTintList(
                    ColorStateList.valueOf(
                            ContextCompat.getColor(
                                    context,
                                    R.color.default_gray
                            )
                    )
            );

            student.setStatus("Present");
        });

        // ABSENT BUTTON

        holder.btnA.setOnClickListener(v -> {

            holder.btnA.setBackgroundTintList(
                    ColorStateList.valueOf(
                            ContextCompat.getColor(
                                    context,
                                    R.color.absent_red
                            )
                    )
            );

            holder.btnP.setBackgroundTintList(
                    ColorStateList.valueOf(
                            ContextCompat.getColor(
                                    context,
                                    R.color.default_gray
                            )
                    )
            );

            holder.btnL.setBackgroundTintList(
                    ColorStateList.valueOf(
                            ContextCompat.getColor(
                                    context,
                                    R.color.default_gray
                            )
                    )
            );

            student.setStatus("Absent");
        });

        // LEAVE BUTTON

        holder.btnL.setOnClickListener(v -> {

            holder.btnL.setBackgroundTintList(
                    ColorStateList.valueOf(
                            ContextCompat.getColor(
                                    context,
                                    R.color.leave_yellow
                            )
                    )
            );

            holder.btnP.setBackgroundTintList(
                    ColorStateList.valueOf(
                            ContextCompat.getColor(
                                    context,
                                    R.color.default_gray
                            )
                    )
            );

            holder.btnA.setBackgroundTintList(
                    ColorStateList.valueOf(
                            ContextCompat.getColor(
                                    context,
                                    R.color.default_gray
                            )
                    )
            );

            student.setStatus("Leave");
        });

        // OPEN DETAILS

        holder.itemView.setOnClickListener(view -> {

            Intent intent = new Intent(
                    context,
                    TakingAttendanceActivity.class
            );

            intent.putExtra(
                    "studentName",
                    student.getStudentName()
            );

            intent.putExtra(
                    "enrollment",
                    student.getEnrollmentNo()
            );

            intent.putExtra(
                    "status",
                    student.getStatus()
            );

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {

        return studentList.size();
    }

    public static class SHViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvEnroll;

        Button btnP, btnA, btnL;

        public SHViewHolder(@NonNull View itemView) {

            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);

            tvEnroll = itemView.findViewById(R.id.tvEnroll);

            btnP = itemView.findViewById(R.id.btnP);

            btnA = itemView.findViewById(R.id.btnA);

            btnL = itemView.findViewById(R.id.btnL);
        }
    }
}