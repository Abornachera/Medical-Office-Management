package edu.unimagdalena.medicalofficemanagement.repository;

import edu.unimagdalena.medicalofficemanagement.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
