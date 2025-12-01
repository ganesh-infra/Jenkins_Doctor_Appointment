package com.example.doctor_appointment.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@Entity
@Table(name = "AP_CONTACTS")
@Getter
@Setter
public class AppointmentContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long contact_id;

    @Column(name = "appt_id", length = 50)
    private String appt_id;

    @Column(name = "URN", length = 50)
    @JsonProperty("URN")
    private String URN;

    @Column(name = "patientname", length = 100)
    private String patientname;

    @Column(name = "secondname", length = 100)
    private String secondname;

    @Column(name = "doctorname", length = 100)
    private String doctorname;

    @Column(name = "mobilenumber", length = 50)
    private String mobilenumber;

    @Column(name = "appt_time")
    private LocalDateTime appt_time;

    @Column(name = "nationality", length = 100)
    private String nationality;

    @Column(name = "appt_start_time")
    private LocalDateTime appt_start_time;

    @Column(name = "appt_end_time")
    private LocalDateTime appt_end_time;

    @Column(name = "lang", length = 10)
    private String lang;

    @Column(name = "completedflag", length = 5)
    private Integer completedflag;

    @Column(name = "reclastupdatedate")
    private LocalDateTime reclastupdatedate;

    @Column(name = "to_process")
    private Integer to_process;

    @Column(name = "batchname", length = 50)
    private String batchname;

	

	public AppointmentContact(Long contact_id, String appt_id, String uRN, String patientname, String secondname,
			String doctorname, String mobilenumber, LocalDateTime appt_time, String nationality,
			LocalDateTime appt_start_time, LocalDateTime appt_end_time, String lang, Integer completedflag,
			LocalDateTime reclastupdatedate, Integer to_process, String batchname) {
		super();
		this.contact_id = contact_id;
		this.appt_id = appt_id;
		URN = uRN;
		this.patientname = patientname;
		this.secondname = secondname;
		this.doctorname = doctorname;
		this.mobilenumber = mobilenumber;
		this.appt_time = appt_time;
		this.nationality = nationality;
		this.appt_start_time = appt_start_time;
		this.appt_end_time = appt_end_time;
		this.lang = lang;
		this.completedflag = completedflag;
		this.reclastupdatedate = reclastupdatedate;
		this.to_process = to_process;
		this.batchname = batchname;
	}
	
	

	public AppointmentContact() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getContact_id() {
		return contact_id;
	}

	public void setContact_id(Long contact_id) {
		this.contact_id = contact_id;
	}

	public String getAppt_id() {
		return appt_id;
	}

	public void setAppt_id(String appt_id) {
		this.appt_id = appt_id;
	}

	public String getURN() {
		return URN;
	}

	public void setURN(String URN) {
		this.URN = URN;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getdoctorname() {
		return doctorname;
	}

	public void setdoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public LocalDateTime getAppt_time() {
		return appt_time;
	}

	public void setAppt_time(LocalDateTime appt_time) {
		this.appt_time = appt_time;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public LocalDateTime getAppt_start_time() {
		return appt_start_time;
	}

	public void setAppt_start_time(LocalDateTime appt_start_time) {
		this.appt_start_time = appt_start_time;
	}

	public LocalDateTime getAppt_end_time() {
		return appt_end_time;
	}

	public void setAppt_end_time(LocalDateTime appt_end_time) {
		this.appt_end_time = appt_end_time;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Integer getCompletedflag() {
		return completedflag;
	}

	public void setCompletedflag(Integer completedflag) {
		this.completedflag = completedflag;
	}

	public LocalDateTime getReclastupdatedate() {
		return reclastupdatedate;
	}

	public void setReclastupdatedate(LocalDateTime reclastupdatedate) {
		this.reclastupdatedate = reclastupdatedate;
	}

	public Integer getTo_process() {
		return to_process;
	}

	public void setTo_process(Integer to_process) {
		this.to_process = to_process;
	}

	public String getBatchname() {
		return batchname;
	}

	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}

	@Override
	public String toString() {
		return "AppointmentContact [contact_id=" + contact_id + ", appt_id=" + appt_id + ", URN=" + URN
				+ ", patientname=" + patientname + ", secondname=" + secondname + ", doctorname=" + doctorname
				+ ", mobilenumber=" + mobilenumber + ", appt_time=" + appt_time + ", nationality=" + nationality
				+ ", appt_start_time=" + appt_start_time + ", appt_end_time=" + appt_end_time + ", lang=" + lang
				+ ", completedflag=" + completedflag + ", reclastupdatedate=" + reclastupdatedate + ", to_process="
				+ to_process + ", batchname=" + batchname + "]";
	}

	
    
    
}