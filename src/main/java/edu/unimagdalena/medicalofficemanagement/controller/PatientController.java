package edu.unimagdalena.medicalofficemanagement.controller;

import edu.unimagdalena.medicalofficemanagement.dto.request.PatientDtoRequest;
import edu.unimagdalena.medicalofficemanagement.dto.response.PatientDtoResponse;
import edu.unimagdalena.medicalofficemanagement.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientDtoResponse>> getAllRooms(){
        return ResponseEntity.ok(patientService.findAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDtoResponse> getPatientById(@PathVariable Long id){
        return ResponseEntity.ok(patientService.findPatientById(id));
    }

    @PostMapping
    public ResponseEntity<PatientDtoResponse> createPatient(@RequestBody @Valid PatientDtoRequest patientDtoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.savePatient(patientDtoRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDtoResponse> updatePatient(@PathVariable  Long id, @RequestBody @Valid PatientDtoRequest patientDtoRequest){
        return ResponseEntity.ok(patientService.updatePatient(id,patientDtoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

}