package edu.unimagdalena.medicalofficemanagement.dto.request;

import edu.unimagdalena.medicalofficemanagement.model.AppointmentStatus;

import java.time.LocalDateTime;

public record AppointmentDtoUpdateRequest(
        LocalDateTime startTime,
        LocalDateTime endTime,
        AppointmentStatus status
) {

}
