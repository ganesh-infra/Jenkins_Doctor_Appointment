package com.example.doctor_appointment.model;

import java.time.LocalDateTime;

public class AppointmentInfo {
    private LocalDateTime apptTime;
    private String doctorName;

    public AppointmentInfo(LocalDateTime apptTime, String doctorName) {
        this.apptTime = apptTime;
        this.doctorName = doctorName;
    }

    public LocalDateTime getApptTime() {
        return apptTime;
    }

    public String getDoctorName() {
        return doctorName;
    }
}