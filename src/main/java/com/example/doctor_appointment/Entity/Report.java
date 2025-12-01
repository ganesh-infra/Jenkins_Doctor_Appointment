package com.example.doctor_appointment.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "ivr_reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Mobile number of the caller/patient
    @Column(name = "ani", nullable = false)
    private String ani;

    @Column(name = "ucid")
    private String ucid;

    // Dialed Number Identification Service (DNIS)
    @Column(name = "dnis")
    private String dnis;

    // Doctor / clinic name
    @Column(name = "doctorname")
    private String doctorname;

    // Language preference
    @Column(name = "language")
    private String language;

    // Appointment batch identifier
    @Column(name = "batchname")
    private String batchname;

    // Start time of the call
    @Column(name = "startdate_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startdate_time;

    // End time of the call
    @Column(name = "enddate_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime enddate_time;

    // Duration in seconds
    @Column(name = "duration")
    private Long duration;

    // Appointment scheduled TIME only (HH:mm:ss)
    @Column(name = "appt_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime appt_time;

    // Agent transfer VDN (4 digits)
    @Pattern(regexp = "\\d{4}", message = "Agent Transfer VDN must be exactly 4 digits")
    @Column(name = "Agent_Transfer", length = 4)
    private String Agent_Transfer;

    // Getters & Setters (generate using Lombok if needed)

    // --- Getters and Setters below ---
    public Long getId() { return id; }

    public String getAni() { return ani; }
    public void setAni(String ani) { this.ani = ani; }

    public String getUcid() { return ucid; }
    public void setUcid(String ucid) { this.ucid = ucid; }

    public String getDnis() { return dnis; }
    public void setDnis(String dnis) { this.dnis = dnis; }

    public String getDoctorname() { return doctorname; }
    public void setDoctorname(String doctorname) { this.doctorname = doctorname; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getBatchname() { return batchname; }
    public void setBatchname(String batchname) { this.batchname = batchname; }

    public LocalDateTime getStartdate_time() { return startdate_time; }
    public void setStartdate_time(LocalDateTime startdate_time) { this.startdate_time = startdate_time; }

    public LocalDateTime getEnddate_time() { return enddate_time; }
    public void setEnddate_time(LocalDateTime enddate_time) { this.enddate_time = enddate_time; }

    public Long getDuration() { return duration; }
    public void setDuration(Long duration) { this.duration = duration; }

    public LocalTime getAppt_time() { return appt_time; }
    public void setAppt_time(LocalTime appt_time) { this.appt_time = appt_time; }

    public String getAgent_Transfer() { return Agent_Transfer; }
    public void setAgent_Transfer(String agent_Transfer) { Agent_Transfer = agent_Transfer; }
}
