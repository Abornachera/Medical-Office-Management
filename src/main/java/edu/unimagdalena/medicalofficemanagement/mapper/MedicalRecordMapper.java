package edu.unimagdalena.medicalofficemanagement.mapper;

import edu.unimagdalena.medicalofficemanagement.dto.request.MedicalRecordDtoRequest;
import edu.unimagdalena.medicalofficemanagement.dto.response.MedicalRecordDtoResponse;
import edu.unimagdalena.medicalofficemanagement.model.MedicalRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MedicalRecordMapper {
    @Mapping(source = "patient.idPatient", target = "idPatient")
    @Mapping(source = "appointment.idAppointment", target = "idAppointment")
    MedicalRecordDtoResponse toMedicalRecordDtoResponse(MedicalRecord medicalRecord);

    //No han sido mapeados los campos de la entidad a la respuesta.
    @Mapping(target = "patient", ignore = true)
    @Mapping(target = "appointment", ignore = true)
    MedicalRecord toEntity(MedicalRecordDtoRequest medicalRecord);

}