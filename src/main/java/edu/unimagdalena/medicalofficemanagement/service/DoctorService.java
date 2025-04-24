package edu.unimagdalena.medicalofficemanagement.service;

import edu.unimagdalena.medicalofficemanagement.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<Doctor> findAll();
    Optional<Doctor> findById(Long id);
    List<Doctor> findBySpecialty(String specialty);
    Doctor save(Doctor doctor);
    Doctor update(Long id, Doctor doctor);
    void delete(Long id);
}
