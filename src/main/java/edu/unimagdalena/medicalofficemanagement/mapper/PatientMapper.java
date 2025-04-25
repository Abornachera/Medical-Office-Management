package edu.unimagdalena.medicalofficemanagement.mapper;

import edu.unimagdalena.medicalofficemanagement.dto.PatientDTO;
import edu.unimagdalena.medicalofficemanagement.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientDTO toDTO (Patient patient);
    Patient toEntity (PatientDTO dto);
}
