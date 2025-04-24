package edu.unimagdalena.medicalofficemanagement.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO {
    private Long id;
    private Long patientId;
    private Long doctorId;
    private Long consultRoomId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status; // SCHEDULED, COMPLETED, CANCELED
}
