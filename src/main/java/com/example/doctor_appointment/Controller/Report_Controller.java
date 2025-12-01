package com.example.doctor_appointment.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctor_appointment.Entity.Report;
import com.example.doctor_appointment.Service.Report_Service;

@RestController
@RequestMapping("/reports")
public class Report_Controller {

    private final Report_Service service;

    public Report_Controller(Report_Service service) {
        this.service = service;
    }

    @GetMapping("/test")
    public String test() {
        return "Dump IVR Reports";
    }

    // Create
 // Create
    @PostMapping("/post-ivrreports")
    public ResponseEntity<?> create(@RequestBody Report record) {
        String doctorname = record.getDoctorname();

        if (doctorname == null || doctorname.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Doctor name(s) required");
        }

        // Normalize ucid and dnis if they come as "undefined"
        if ("undefined".equalsIgnoreCase(record.getUcid())) {
            record.setUcid(null);
        }
        if ("undefined".equalsIgnoreCase(record.getDnis())) {
            record.setDnis(null);
        }

        String[] doctors = doctorname.split(",");
        List<Report> savedReports = new ArrayList<>();

        for (String doc : doctors) {
            Report newRecord = new Report();
            newRecord.setAni(record.getAni());
            newRecord.setUcid(record.getUcid());
            newRecord.setDnis(record.getDnis());
            newRecord.setBatchname(record.getBatchname());
            newRecord.setStartdate_time(record.getStartdate_time());
            newRecord.setEnddate_time(record.getEnddate_time());
            newRecord.setDuration(record.getDuration());
            newRecord.setLanguage(record.getLanguage());
            newRecord.setAgent_Transfer(record.getAgent_Transfer()); // agent VDN / transfer

            newRecord.setDoctorname(doc.trim());
            newRecord.setAppt_time(record.getAppt_time());

            savedReports.add(service.save(newRecord));
        }

        return ResponseEntity.ok(savedReports);
    }


    // Read all
    @GetMapping("/get-ivrreports")
    public ResponseEntity<List<Report>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Report> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update
 // Update
    @PutMapping("/{id}")
    public ResponseEntity<Report> update(@PathVariable Long id, @RequestBody Report record) {
        return service.findById(id)
                .map(existing -> {
                    existing.setAni(record.getAni());
                    existing.setUcid(record.getUcid());
                    existing.setDnis(record.getDnis());
                    existing.setStartdate_time(record.getStartdate_time());
                    existing.setEnddate_time(record.getEnddate_time());
                    existing.setDoctorname(record.getDoctorname());
                    existing.setAppt_time(record.getAppt_time());
                    existing.setBatchname(record.getBatchname());
                    existing.setDuration(record.getDuration());
                    existing.setLanguage(record.getLanguage());
                    existing.setAgent_Transfer(record.getAgent_Transfer());                 // ✅ update agent VDN
                    return ResponseEntity.ok(service.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    
 // Get by batchname
    @GetMapping("/batch/{batchname}")
    public ResponseEntity<List<Report>> getByBatchname(@PathVariable String batchname) {
        List<Report> reports = service.findByBatchname(batchname);

        if (reports.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reports);
    }


    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
