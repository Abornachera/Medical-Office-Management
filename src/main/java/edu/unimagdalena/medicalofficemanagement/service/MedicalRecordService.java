package edu.unimagdalena.medicalofficemanagement.service;

import edu.unimagdalena.medicalofficemanagement.model.MedicalRecord;

import java.util.List;
import java.util.Optional;

public interface MedicalRecordService {
    List<MedicalRecord> findAll();
    Optional<MedicalRecord> findById(Long id);
    List<MedicalRecord> findByPatientId(Long patientId);
    MedicalRecord save(MedicalRecord medicalRecord);
    void delete(Long id);
}
