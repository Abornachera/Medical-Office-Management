package edu.unimagdalena.medicalofficemanagement.dto.request;

import java.time.LocalTime;

public record DoctorDtoRequest(String fullName,
                               String email,
                               String speciality,
                               LocalTime availableFrom,
                               LocalTime availableTo) {

}
