package com.example.attendancesystem;


public class AttendanceModel {

    String date, totalHours, time;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(String totalHours) {
        this.totalHours = totalHours;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public AttendanceModel(String date, String totalHours, String time) {
        this.date = date;
        this.totalHours = totalHours;
        this.time = time;
    }


}

