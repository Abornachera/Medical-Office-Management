package edu.unimagdalena.medicalofficemanagement.service.impl;

import edu.unimagdalena.medicalofficemanagement.model.Doctor;
import edu.unimagdalena.medicalofficemanagement.repository.DoctorRepository;
import edu.unimagdalena.medicalofficemanagement.service.DoctorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public List<Doctor> findBySpecialty(String specialty) {
        return doctorRepository.findBySpecialty(specialty);
    }

    @Override
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(Long id, Doctor doctor) {
        Doctor existing = doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
        existing.setFullName(doctor.getFullName());
        existing.setEmail(doctor.getEmail());
        existing.setSpecialty(doctor.getSpecialty());
        existing.setAvailableFrom(doctor.getAvailableFrom());
        existing.setAvailableTo(doctor.getAvailableTo());
        return doctorRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }
}
