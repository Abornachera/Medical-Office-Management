package edu.unimagdalena.medicalofficemanagement.repository;

import edu.unimagdalena.medicalofficemanagement.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findBySpecialty(String specialty);
}
