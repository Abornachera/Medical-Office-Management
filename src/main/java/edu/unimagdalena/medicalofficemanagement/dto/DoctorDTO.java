package edu.unimagdalena.medicalofficemanagement.dto;

import lombok.Data;
import java.time.LocalTime;

@Data
public class DoctorDTO {
    private Long id;
    private String fullName;
    private String email;
    private String specialty;
    private LocalTime availableFrom;
    private LocalTime availableTo;
}
