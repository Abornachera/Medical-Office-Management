package edu.unimagdalena.medicalofficemanagement.mapper;

import edu.unimagdalena.medicalofficemanagement.dto.AppointmentDTO;
import edu.unimagdalena.medicalofficemanagement.model.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(source = "patient.id", target = "patientId")
    @Mapping(source = "doctor.id", target = "doctorId")
    @Mapping(source = "consultRoom.id", target = "consultRoomId")
    AppointmentDTO toDto(Appointment appointment);

    @Mapping(target = "patient.id", source = "patientId")
    @Mapping(target = "doctor.id", source = "doctorId")
    @Mapping(target = "consultRoom.id", source = "consultRoomId")
    Appointment toEntity(AppointmentDTO appointmentDTO);
}
