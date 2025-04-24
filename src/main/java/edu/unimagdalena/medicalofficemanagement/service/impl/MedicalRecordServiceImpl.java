package edu.unimagdalena.medicalofficemanagement.service.impl;

import edu.unimagdalena.medicalofficemanagement.model.MedicalRecord;
import edu.unimagdalena.medicalofficemanagement.repository.MedicalRecordRepository;
import edu.unimagdalena.medicalofficemanagement.service.MedicalRecordService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;

    @Override
    public List<MedicalRecord> findAll() {
        return medicalRecordRepository.findAll();
    }

    @Override
    public Optional<MedicalRecord> findById(Long id) {
        return medicalRecordRepository.findById(id);
    }

    @Override
    public List<MedicalRecord> findByPatientId(Long patientId) {
        return medicalRecordRepository.findByPatientId(patientId);
    }

    @Override
    public MedicalRecord save(MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }

    @Override
    public void delete(Long id) {
        if (!medicalRecordRepository.existsById(id)) {
            throw new EntityNotFoundException("Medical record not found");
        }
        medicalRecordRepository.deleteById(id);
    }
}
