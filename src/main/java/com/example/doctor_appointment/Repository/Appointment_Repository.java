package com.example.doctor_appointment.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.doctor_appointment.Entity.AppointmentContact;
import com.example.doctor_appointment.model.AppointmentInfo;

@Repository
public interface Appointment_Repository extends JpaRepository<AppointmentContact, Long> {
	
	@Query("SELECT COUNT(a) FROM AppointmentContact a WHERE a.mobilenumber = :mobilenumber AND a.batchname = :batchname")
    long countByMobileAndBatch(String mobilenumber, String batchname);
	
	@Query("SELECT new com.example.doctor_appointment.model.AppointmentInfo(a.appt_time, a.doctorname) " +
	           "FROM AppointmentContact a WHERE a.mobilenumber = :mobilenumber AND a.batchname = :batchname")
	    List<AppointmentInfo> findAppointmentsByMobileAndBatch(String mobilenumber, String batchname);
	
	 @Modifying
	    @Transactional
	    @Query("UPDATE AppointmentContact a " +
	           "SET a.appt_start_time = CURRENT_TIMESTAMP, a.to_process = 1 " +
	           "WHERE a.mobilenumber = :mobilenumber AND a.batchname = :batchname")
	    int updateStartTimeAndProcess(@Param("mobilenumber") String mobilenumber,
	                                  @Param("batchname") String batchname);
	
	// Optional<AppointmentContact> findByMobilenumberAndBatchname(String mobilenumber, String batchname);
	 
	 @Modifying
	    @Transactional
	    @Query(value = "UPDATE AppointmentContact " +
	                   "SET completedflag = :completedFlag, " +
	                   "    appt_end_time   = :apptEndtime, " +
	                   "    to_process     = :toProcess " +
	                   "WHERE mobilenumber = :mobilenumber " +
	                   "  AND batchname    = :batchname"
	          )
	    int updateAppointment(@Param("mobilenumber") String mobilenumber,
	                          @Param("batchname") String batchname,
	                          @Param("completedFlag") Integer completedFlag,
	                          @Param("apptEndtime") LocalDateTime apptEndtime,
	                          @Param("toProcess") Integer toProcess);
	 
	 
	 List<AppointmentContact> findByMobilenumberAndBatchname(String mobilenumber, String batchname);


	}

	
	



