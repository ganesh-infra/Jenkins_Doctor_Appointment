package com.example.doctor_appointment.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctor_appointment.Entity.Report;

public interface Report_Repository extends JpaRepository<Report, Long>{
	
	List<Report> findByBatchname(String batchname);


}
