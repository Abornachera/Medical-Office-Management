package edu.unimagdalena.medicalofficemanagement.controller;

import edu.unimagdalena.medicalofficemanagement.dto.request.MedicalRecordDtoRequest;
import edu.unimagdalena.medicalofficemanagement.dto.response.MedicalRecordDtoResponse;
import edu.unimagdalena.medicalofficemanagement.service.MedicalRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/records")
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @GetMapping
    public ResponseEntity<List<MedicalRecordDtoResponse>> getAllMedicalRecords(){
        return ResponseEntity.ok(medicalRecordService.findAllMedicalRecords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecordDtoResponse> getMedicalRecordById(@PathVariable Long id){
        return ResponseEntity.ok(medicalRecordService.findById(id));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalRecordDtoResponse>> getMedicalRecordsByPatientId(@PathVariable Long patientId){
        return ResponseEntity.ok(medicalRecordService.findMedicalRecordsByPatient(patientId));
    }

    @PostMapping
    public ResponseEntity<MedicalRecordDtoResponse> createMedicalRecord(@Valid @RequestBody MedicalRecordDtoRequest medicalRecordDtoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(medicalRecordService.saveMedicalRecord(medicalRecordDtoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable Long id){
        medicalRecordService.deleteMedicalRecord(id);
        return ResponseEntity.noContent().build();
    }


}