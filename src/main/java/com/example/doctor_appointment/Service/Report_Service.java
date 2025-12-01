package com.example.doctor_appointment.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.doctor_appointment.Entity.Report;
import com.example.doctor_appointment.Repository.Report_Repository;

@Service
public class Report_Service {



    private final Report_Repository repository;

    public Report_Service(Report_Repository repository) {
        this.repository = repository;
    }

    public Report save(Report record) {
        return repository.save(record);
    }

    public List<Report> findAll() {
        return repository.findAll();
    }

    public Optional<Report> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    public List<Report> findByBatchname(String batchname) {
        return repository.findByBatchname(batchname);
    }

}
