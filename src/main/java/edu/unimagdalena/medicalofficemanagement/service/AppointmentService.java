package edu.unimagdalena.medicalofficemanagement.service;

import edu.unimagdalena.medicalofficemanagement.dto.request.AppointmentDtoRequest;
import edu.unimagdalena.medicalofficemanagement.dto.request.AppointmentDtoUpdateRequest;
import edu.unimagdalena.medicalofficemanagement.dto.response.AppointmentDtoResponse;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    List<AppointmentDtoResponse> findAllAppointments();
    AppointmentDtoResponse findAppointmentById(Long id);
    AppointmentDtoResponse saveAppointment(AppointmentDtoRequest appointmentDtoRequest);
    AppointmentDtoResponse updateAppointment(Long id, AppointmentDtoUpdateRequest appointmentDtoRequest);
    void deleteAppointment(Long id);
}
