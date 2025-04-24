package edu.unimagdalena.medicalofficemanagement.controller;

import edu.unimagdalena.medicalofficemanagement.dto.MedicalRecordDTO;
import edu.unimagdalena.medicalofficemanagement.mapper.MedicalRecordMapper;
import edu.unimagdalena.medicalofficemanagement.model.MedicalRecord;
import edu.unimagdalena.medicalofficemanagement.service.MedicalRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;
    private final MedicalRecordMapper medicalRecordMapper;

    @GetMapping
    public List<MedicalRecordDTO> findAll() {
        return medicalRecordService.findAll().stream()
                .map(medicalRecordMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecordDTO> findById(@PathVariable Long id) {
        return medicalRecordService.findById(id)
                .map(medicalRecordMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/patient/{patientId}")
    public List<MedicalRecordDTO> findByPatientId(@PathVariable Long patientId) {
        return medicalRecordService.findByPatientId(patientId).stream()
                .map(medicalRecordMapper::toDto)
                .toList();
    }

    @PostMapping
    public ResponseEntity<MedicalRecordDTO> create(@Valid @RequestBody MedicalRecordDTO dto) {
        MedicalRecord record = medicalRecordMapper.toEntity(dto);
        MedicalRecord saved = medicalRecordService.save(record);
        return ResponseEntity.ok(medicalRecordMapper.toDto(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        medicalRecordService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
