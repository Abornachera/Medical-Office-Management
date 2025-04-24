package edu.unimagdalena.medicalofficemanagement.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MedicalRecordDTO {
    private Long id;
    private Long appointmentId;
    private Long patientId;
    private String diagnosis;
    private String notes;
    private LocalDateTime createdAt;
}
