package edu.unimagdalena.medicalofficemanagement.dto.response;

import java.time.LocalTime;

public record DoctorDtoResponse(String fullName,
                                String email,
                                String speciality,
                                LocalTime availableFrom,
                                LocalTime availableTo)
{


}
