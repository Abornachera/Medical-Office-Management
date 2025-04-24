package edu.unimagdalena.medicalofficemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecordDTO {

    private Long id;

    @NotNull
    private Long appointmentId;

    @NotNull
    private Long patientId;

    @NotBlank
    private String diagnosis;

    @NotBlank
    private String notes;

    private LocalDateTime createdAt;
}
