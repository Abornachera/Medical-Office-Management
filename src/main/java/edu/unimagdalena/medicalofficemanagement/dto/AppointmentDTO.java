package edu.unimagdalena.medicalofficemanagement.dto;

import edu.unimagdalena.medicalofficemanagement.model.AppointmentStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentDTO {
    private Long id;

    @Future
    private LocalDateTime startTime;

    @Future
    private LocalDateTime endTime;

    private AppointmentStatus status;

    @NotNull
    private Long patientId;
    @NotNull
    private Long consultRoomId;
    @NotNull
    private Long doctorId;

}
