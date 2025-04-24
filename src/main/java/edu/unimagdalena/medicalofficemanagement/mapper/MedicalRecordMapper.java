package edu.unimagdalena.medicalofficemanagement.mapper;

import edu.unimagdalena.medicalofficemanagement.dto.MedicalRecordDTO;
import edu.unimagdalena.medicalofficemanagement.model.MedicalRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MedicalRecordMapper {

    @Mapping(source = "appointment.id", target = "appointmentId")
    @Mapping(source = "patient.id", target = "patientId")
    MedicalRecordDTO toDto(MedicalRecord medicalRecord);

    @Mapping(target = "appointment.id", source = "appointmentId")
    @Mapping(target = "patient.id", source = "patientId")
    MedicalRecord toEntity(MedicalRecordDTO medicalRecordDTO);
}
