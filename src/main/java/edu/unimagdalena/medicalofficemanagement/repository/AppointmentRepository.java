package edu.unimagdalena.medicalofficemanagement.repository;

import edu.unimagdalena.medicalofficemanagement.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("SELECT a FROM Appointment a WHERE a.consultRoom.idConsultRoom = :consult_room_id AND (a.startTime < :end_time AND a.endTime > :start_time)")
    List<Appointment> findConflicts(
            @Param("consult_room_id") Long idConsultRoom,
            @Param("start_time") LocalDateTime startTime,
            @Param("end_time") LocalDateTime endTime
    );

    @Query("SELECT a FROM Appointment a WHERE a.doctor.idDoctor = :id_doctor AND (a.startTime < :end_time AND a.endTime > :start_time)")
    List<Appointment> findConflicsWithDoctor(
            @Param("id_doctor") Long idDoctor,
            @Param("start_time") LocalDateTime startTime,
            @Param("end_time") LocalDateTime endTime
    );

}
