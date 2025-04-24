package edu.unimagdalena.medicalofficemanagement.service.impl;

import edu.unimagdalena.medicalofficemanagement.model.Appointment;
import edu.unimagdalena.medicalofficemanagement.repository.AppointmentRepository;
import edu.unimagdalena.medicalofficemanagement.service.AppointmentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<Appointment> findById(Long id) {
        return appointmentRepository.findById(id);
    }



    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment update(Long id, Appointment appointment) {
        Appointment existing = appointmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found"));
        existing.setStartTime(appointment.getStartTime());
        existing.setEndTime(appointment.getEndTime());
        existing.setStatus(appointment.getStatus());
        existing.setDoctor(appointment.getDoctor());
        existing.setPatient(appointment.getPatient());
        existing.setConsultRoom(appointment.getConsultRoom());
        return appointmentRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }
}
