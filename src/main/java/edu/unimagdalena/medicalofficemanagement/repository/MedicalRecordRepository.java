package edu.unimagdalena.medicalofficemanagement.repository;

import edu.unimagdalena.medicalofficemanagement.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    List<MedicalRecord> findByPatientId(Long patientId);
}
