package edu.unimagdalena.medicalofficemanagement.dto.response;

import java.time.LocalTime;

public record DoctorDtoResponse(Long idDoctor,
                                String fullName,
                                String email,
                                String speciality,
                                LocalTime availableFrom,
                                LocalTime availableTo)
{


}
