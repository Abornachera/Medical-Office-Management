package edu.unimagdalena.medicalofficemanagement.dto;

import lombok.Data;

@Data
public class PatientDTO {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
}
