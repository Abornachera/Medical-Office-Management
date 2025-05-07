package edu.unimagdalena.medicalofficemanagement.service;

import java.util.List;

public interface MedicalRecordService {
    MedicalRecordDTO createMedicalRecord(MedicalRecordDTO dto);
    List<MedicalRecordDTO> getAllMedicalRecords();
    MedicalRecordDTO getMedicalRecordById(Long id);
    List<MedicalRecordDTO> getMedicalRecordsByPatientId(Long patientId);
    MedicalRecordDTO updateMedicalRecord(Long id, MedicalRecordDTO dto);
    void deleteMedicalRecord(Long id);
}
