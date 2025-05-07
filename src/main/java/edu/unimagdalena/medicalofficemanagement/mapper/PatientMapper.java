package edu.unimagdalena.medicalofficemanagement.mapper;

import edu.unimagdalena.medicalofficemanagement.dto.request.PatientDtoRequest;
import edu.unimagdalena.medicalofficemanagement.dto.response.PatientDtoResponse;
import edu.unimagdalena.medicalofficemanagement.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientDtoResponse toPatientDtoResponse(Patient patient);
    Patient toEntity(PatientDtoRequest patient);
}
