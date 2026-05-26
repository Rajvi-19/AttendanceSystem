package com.example.attendance_system;

import java.io.Serializable;

public class TimeDurationModel implements Serializable {

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

    public TimeDurationModel(String date, String totalHours, String time) {
        this.date = date;
        this.totalHours = totalHours;
        this.time = time;
    }


}
