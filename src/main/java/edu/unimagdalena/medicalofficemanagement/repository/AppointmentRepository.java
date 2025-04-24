package edu.unimagdalena.medicalofficemanagement.repository;

import edu.unimagdalena.medicalofficemanagement.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByDoctorIdAndStartTimeBetween(Long doctorId, LocalDateTime start, LocalDateTime end);

    List<Appointment> findByConsultRoomIdAndStartTimeBetween(Long roomId, LocalDateTime start, LocalDateTime end);

    List<Appointment> findByPatientId(Long patientId);


}
