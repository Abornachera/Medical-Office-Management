package edu.unimagdalena.medicalofficemanagement.service;

import edu.unimagdalena.medicalofficemanagement.dto.request.PatientDtoRequest;
import edu.unimagdalena.medicalofficemanagement.dto.response.PatientDtoResponse;

import java.util.List;

public interface PatientService {
    List<PatientDtoResponse> findAllPatients();
    PatientDtoResponse findPatientById(Long idPatient);
    PatientDtoResponse savePatient(PatientDtoRequest patient);
    PatientDtoResponse updatePatient(Long idPatient, PatientDtoRequest patient);
    void deletePatient(Long idPatient);
}
