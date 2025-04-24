package edu.unimagdalena.medicalofficemanagement.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentDTO {

    private Long id;

    @NotNull
    private Long patientId;

    @NotNull
    private Long doctorId;

    @NotNull
    private Long consultRoomId;

    @Future
    private LocalDateTime startTime;

    @Future
    private LocalDateTime endTime;

    @NotNull
    private String status; // SCHEDULED, COMPLETED, CANCELED
}
