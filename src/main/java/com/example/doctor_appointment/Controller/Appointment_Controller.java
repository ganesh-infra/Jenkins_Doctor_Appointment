
package com.example.doctor_appointment.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctor_appointment.Entity.AppointmentContact;
import com.example.doctor_appointment.Service.Appointment_Service;
import com.example.doctor_appointment.model.AppointmentInfo;

@RestController
@RequestMapping("/appointments")
public class Appointment_Controller {

    private  Appointment_Service service;

   

    public Appointment_Controller(Appointment_Service service) {
		super();
		this.service = service;
	}

	@GetMapping("/test")
	public String test() {
		return "Booked your doctor Appointment";
	}

	// Create appointment
    @PostMapping
    public AppointmentContact create(@RequestBody AppointmentContact appointment) {
        return service.save(appointment);
    }

    // Get all
    
    @GetMapping("/get-all-appointments")
    public List<AppointmentContact> getAll() {
        return service.getAll();
    }

    // Get by ID
    @GetMapping("/by-id/{id}")
    public AppointmentContact getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // List of departments
    @GetMapping("/departments")
    public List<String> getDepartments() {
        return Arrays.asList(
            "Anaesthesia clinic",
            "General Surgery clinic",
            "Bariatric surgery clinic",
            "E.N.T clinic",
            "Neurosurgery clinic",
            "Ophthalmology clinic",
            "Orthopedic Surgery clinic",
            "Urology clinic",
            "Vascular Surgery clinic",
            "Radiology",
            "Gynaecology clinic",
            "Pulmonology clinic",
            "Rheumatology clinic",
            "Endocrinology & diabetes clinic",
            "Gastroenterology clinic",
            "Dermatology clinic",
            "Cardiology clinic",
            "Dietitian clinic",
            "Pediatric Medical clinic",
            "Physiotherapy",
            "Primary Care Clinic",
            "Neurology clinic",
            "Oncology clinic",
            "Thalassemia clinic",
            "Audiology Unit",
            "Nephrology clinic",
            "Family Medicine",
            "Corporate Clinic",
            "Lactation clinic",
            "Sharjah Breast Center",
            "Wound Care Clinic",
            "Diabetic Foot Clinic",
            "Pediatric Cardiology clinic",
            "Diabetic Educators Clinic",
            "Gynecology & Fertility Clinic",
            "HIMCHAN-UHS SPINE & JOINT CENTER"
        );
    }
    
    @GetMapping("/get-count")
    public long getCount(
            @RequestParam String mobilenumber,
            @RequestParam String batchname) {
        return service.getCount(mobilenumber, batchname);
    }
    
    @GetMapping("/get-appointments")
    public List<AppointmentInfo> getAppointments(
            @RequestParam String mobilenumber,
            @RequestParam String batchname) {
        return service.getAppointments(mobilenumber, batchname);
    }
    
    @PutMapping("/update-start")
    public String updateStartTime(@RequestParam String mobilenumber,
                                  @RequestParam String batchname) {
        int rows = service.updateAppointmentStart(mobilenumber, batchname);
        return rows > 0 ? rows + " row(s) updated" : "No matching records found";
    }
    
    @PutMapping("/update-appointment")
    public String updateAppointment(@RequestBody AppointmentContact request) {
        int rows = service.updateAppointment(
                request.getMobilenumber(),
                request.getBatchname(),
                request.getCompletedflag(),
                request.getAppt_end_time(),
                request.getTo_process()
        );

        return rows > 0 ? "Update successful" : "No record updated";
    }
    
    @GetMapping("/by-mobile-batch")
    public ResponseEntity<?> getByMobileAndBatch(
            @RequestParam String mobilenumber,
            @RequestParam String batchname) {
        
        List<AppointmentContact> appointments = service.getByMobileAndBatch(mobilenumber, batchname);

        if (appointments.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(appointments);
    }


}
