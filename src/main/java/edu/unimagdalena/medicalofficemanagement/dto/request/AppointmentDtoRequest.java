package edu.unimagdalena.medicalofficemanagement.dto.request;

import edu.unimagdalena.medicalofficemanagement.model.AppointmentStatus;

import java.time.LocalDateTime;

public record AppointmentDtoRequest(
        Long idPatient,
        Long idDoctor,
        Long idConsultRoom,
        LocalDateTime startTime,
        LocalDateTime endTime,
        AppointmentStatus status
) {

}
