package edu.unimagdalena.medicalofficemanagement.service;

import edu.unimagdalena.medicalofficemanagement.dto.request.MedicalRecordDtoRequest;
import edu.unimagdalena.medicalofficemanagement.dto.response.MedicalRecordDtoResponse;

import java.util.List;

public interface MedicalRecordService {
    List<MedicalRecordDtoResponse> findAllMedicalRecords();
    MedicalRecordDtoResponse findById(Long id);
    List<MedicalRecordDtoResponse> findMedicalRecordsByPatient(Long id);
    MedicalRecordDtoResponse saveMedicalRecord(MedicalRecordDtoRequest medicalRecordDtoRequest);
    void deleteMedicalRecord(Long id);
}
