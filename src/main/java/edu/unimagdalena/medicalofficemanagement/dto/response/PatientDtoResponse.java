package edu.unimagdalena.medicalofficemanagement.dto.response;

public record PatientDtoResponse(
        Long idPatient,
        String fullName,
        String email,
        String phone
) {

}
