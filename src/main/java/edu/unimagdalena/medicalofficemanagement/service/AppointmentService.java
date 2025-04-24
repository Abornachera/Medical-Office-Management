package edu.unimagdalena.medicalofficemanagement.service;

import edu.unimagdalena.medicalofficemanagement.model.Appointment;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<Appointment> findAll();
    Optional<Appointment> findById(Long id);
    Appointment save(Appointment appointment);
    Appointment update(Long id, Appointment appointment);
    void delete(Long id);
}
