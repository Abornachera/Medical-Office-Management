package edu.unimagdalena.medicalofficemanagement.controller;

import edu.unimagdalena.medicalofficemanagement.dto.AppointmentDTO;
import edu.unimagdalena.medicalofficemanagement.mapper.AppointmentMapper;
import edu.unimagdalena.medicalofficemanagement.model.Appointment;
import edu.unimagdalena.medicalofficemanagement.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;

    @GetMapping
    public List<AppointmentDTO> findAll() {
        return appointmentService.findAll().stream()
                .map(appointmentMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> findById(@PathVariable Long id) {
        return appointmentService.findById(id)
                .map(appointmentMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> create(@Valid @RequestBody AppointmentDTO dto) {
        Appointment appointment = appointmentMapper.toEntity(dto);
        Appointment saved = appointmentService.save(appointment);
        return ResponseEntity.ok(appointmentMapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> update(@PathVariable Long id, @Valid @RequestBody AppointmentDTO dto) {
        Appointment updated = appointmentService.update(id, appointmentMapper.toEntity(dto));
        return ResponseEntity.ok(appointmentMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        appointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
