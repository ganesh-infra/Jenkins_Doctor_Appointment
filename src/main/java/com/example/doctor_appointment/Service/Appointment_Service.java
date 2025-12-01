package com.example.doctor_appointment.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctor_appointment.Entity.AppointmentContact;
import com.example.doctor_appointment.Repository.Appointment_Repository;
import com.example.doctor_appointment.model.AppointmentInfo;

@Service
public class Appointment_Service {

	private  Appointment_Repository repository;

   

    public Appointment_Service(Appointment_Repository repository) {
		super();
		this.repository = repository;
	}

	public AppointmentContact save(AppointmentContact appointment) {
        return repository.save(appointment);
    }

    public List<AppointmentContact> getAll() {
        return repository.findAll();
    }

    public AppointmentContact getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    
    public AppointmentContact updateDepartment(Long contactId, String doctorname) {
        AppointmentContact appointment = repository.findById(contactId).orElse(null);
        if (appointment != null) {
            appointment.setdoctorname(doctorname);
            return repository.save(appointment);
        }
        return null; // Not found
    }
    
    public long getCount(String mobileNumber, String batchName) {
        return repository.countByMobileAndBatch(mobileNumber, batchName);
    }
    
    public List<AppointmentInfo> getAppointments(String mobileNumber, String batchName) {
        return repository.findAppointmentsByMobileAndBatch(mobileNumber, batchName);
    }
    
    public int updateAppointmentStart(String mobilenumber, String batchname) {
        return repository.updateStartTimeAndProcess(mobilenumber, batchname);
    }
    
//    public AppointmentContact updateAppointment(String mobilenumber, String batchname) {
//        return repository.findByMobilenumberAndBatchname(mobilenumber, batchname)
//                .map(appt -> {
//                    appt.setCompletedflag(batchname);
//                    appt.setAppt_end_time(LocalDateTime.now());
//                    appt.setTo_process(false);
//                    return repository.save(appt);
//                })
//                .orElseThrow(() -> new RuntimeException("Appointment not found!"));
//    }
//    
    public int updateAppointment(String mobilenumber,
            String batchname,
            Integer completedFlag,
            LocalDateTime apptEndtime,
            Integer toProcess) {
    		return repository.updateAppointment(
    								mobilenumber, batchname, completedFlag, apptEndtime, toProcess);
}
   public List<AppointmentContact> getByMobileAndBatch(String mobilenumber, String batchname) {
        return repository.findByMobilenumberAndBatchname(mobilenumber, batchname);
    }


    
}