package edu.unimagdalena.medicalofficemanagement.service.impl;

import edu.unimagdalena.medicalofficemanagement.model.Patient;
import edu.unimagdalena.medicalofficemanagement.repository.PatientRepository;
import edu.unimagdalena.medicalofficemanagement.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient update(Long id, Patient patient) {
        Patient existing = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));
        existing.setFullName(patient.getFullName());
        existing.setEmail(patient.getEmail());
        existing.setPhone(patient.getPhone());
        return patientRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }
}
