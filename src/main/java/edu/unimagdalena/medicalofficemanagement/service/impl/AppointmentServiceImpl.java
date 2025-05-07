package edu.unimagdalena.medicalofficemanagement.service.impl;

import edu.unimagdalena.medicalofficemanagement.dto.request.AppointmentDtoRequest;
import edu.unimagdalena.medicalofficemanagement.dto.request.AppointmentDtoUpdateRequest;
import edu.unimagdalena.medicalofficemanagement.dto.response.AppointmentDtoResponse;
import edu.unimagdalena.medicalofficemanagement.exception.notFound.AppointmentNotFoundException;
import edu.unimagdalena.medicalofficemanagement.exception.notFound.ConsultRoomNotFoundException;
import edu.unimagdalena.medicalofficemanagement.exception.notFound.DoctorNotFoundException;
import edu.unimagdalena.medicalofficemanagement.exception.notFound.PatientNotFoundException;
import edu.unimagdalena.medicalofficemanagement.repository.AppointmentRepository;
import edu.unimagdalena.medicalofficemanagement.repository.ConsultRoomRepository;
import edu.unimagdalena.medicalofficemanagement.repository.DoctorRepository;
import edu.unimagdalena.medicalofficemanagement.repository.PatientRepository;

import edu.unimagdalena.medicalofficemanagement.exception.*;
import edu.unimagdalena.medicalofficemanagement.mapper.AppointmentMapper;

import edu.unimagdalena.medicalofficemanagement.model.*;
import edu.unimagdalena.medicalofficemanagement.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;
    private AppointmentMapper appointmentMapper;
    private PatientRepository patientRepository;
    private ConsultRoomRepository consultRoomRepository;
    private DoctorRepository doctorRepository;


    @Override
    public List<AppointmentDtoResponse> findAllAppointments() {
        return appointmentRepository.findAll().stream()
                .map(appointmentMapper::toAppointmentDtoResponse)
                .toList();
    }

    @Override
    public AppointmentDtoResponse findAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment with ID: " + id + " Not Found"));

        return appointmentMapper.toAppointmentDtoResponse(appointment);
    }

    @Override
    public AppointmentDtoResponse saveAppointment(AppointmentDtoRequest appointmentDtoRequest) {

        validarRangoHorario(appointmentDtoRequest.startTime(), appointmentDtoRequest.endTime());

        Patient patient = patientRepository.findById(appointmentDtoRequest.idPatient())
                .orElseThrow(() -> new PatientNotFoundException("Patient with ID: " + appointmentDtoRequest.idPatient() + " not found"));

        Doctor doctor = doctorRepository.findById(appointmentDtoRequest.idDoctor())
                .orElseThrow(() -> new DoctorNotFoundException("Doctor with ID: " + appointmentDtoRequest.idDoctor() + " not Found"));

        ConsultRoom consultRoom = consultRoomRepository.findById(appointmentDtoRequest.idConsultRoom())
                .orElseThrow(() -> new ConsultRoomNotFoundException("Consult Room with ID: " + appointmentDtoRequest.idConsultRoom() + " not Found"));

        List<Appointment> conflicts = appointmentRepository.findConflicts(
                appointmentDtoRequest.idConsultRoom(),
                appointmentDtoRequest.startTime(),
                appointmentDtoRequest.endTime()
        );

        if(!conflicts.isEmpty()){
            throw new ConsultRoomAlreadyBookedException("Consult room already booked for the selected time slot");
        }

        List<Appointment> conflictsDoctor = appointmentRepository.findConflicsWithDoctor(
                appointmentDtoRequest.idDoctor(),
                appointmentDtoRequest.startTime(),
                appointmentDtoRequest.endTime());

        if(!conflictsDoctor.isEmpty()){
            throw new DoctorAlreadyBookedException("Doctor has been already booked for the selected time slot");
        }


        if(appointmentDtoRequest.startTime().toLocalTime().isBefore(doctor.getAvailableFrom()) || appointmentDtoRequest.endTime().toLocalTime().isAfter(doctor.getAvailableTo())){
            throw new OutsideWorkingHoursException("The appointment time is outside the doctor's available working hours");
        }

        Appointment appointment = appointmentMapper.toEntity(appointmentDtoRequest);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setConsultRoom(consultRoom);

        return appointmentMapper.toAppointmentDtoResponse(appointmentRepository.save(appointment));
    }

    @Override
    public AppointmentDtoResponse updateAppointment(Long id, AppointmentDtoUpdateRequest appointmentDtoRequest) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment with ID: " + id + " Not Found"));


        if (appointment.getStatus() == AppointmentStatus.COMPLETED) {
            throw new AppointmentAlreadyCompletedException("Appointment is already marked as COMPLETED");
        }

        if (appointment.getStartTime().isBefore(LocalDateTime.now())) {
            throw new AppointmentInThePastException("Cannot modify an appointment that has already occurred");
        }

        validarRangoHorario(appointmentDtoRequest.startTime(), appointmentDtoRequest.endTime());

        appointmentMapper.updateAppointmentFromDto(appointmentDtoRequest, appointment);

        return appointmentMapper.toAppointmentDtoResponse(appointmentRepository.save(appointment));

    }

    @Override
    public void deleteAppointment(Long id) {

        if(!appointmentRepository.existsById(id)){
            throw new AppointmentNotFoundException("Appointment with ID: " + id + " not Found");
        }

        appointmentRepository.deleteById(id);
    }

    private void validarRangoHorario(LocalDateTime inicio, LocalDateTime fin) {
        if (inicio.isAfter(fin) || inicio.equals(fin)) {
            throw new InvalidTimeRangeException("Start time must be before end time");
        }
    }
}