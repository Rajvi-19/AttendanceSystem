package com.example.attendance_system;

public class StudentModel {

    String studentName;

    String enrollmentNo;

    String status;

    public StudentModel(String studentName,
                        String enrollmentNo) {

        this.studentName = studentName;

        this.enrollmentNo = enrollmentNo;

        this.status = "";
    }

    public String getStudentName() {
        return studentName;
    }

    public String getEnrollmentNo() {
        return enrollmentNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}