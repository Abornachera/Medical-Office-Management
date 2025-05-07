package edu.unimagdalena.medicalofficemanagement.mapper;

import edu.unimagdalena.medicalofficemanagement.dto.request.DoctorDtoRequest;
import edu.unimagdalena.medicalofficemanagement.dto.response.DoctorDtoResponse;
import edu.unimagdalena.medicalofficemanagement.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    DoctorDtoResponse toDoctorDtoResponse(Doctor doctor);

    @Mapping(target = "idDoctor", ignore = true)
    Doctor toEntity(DoctorDtoRequest doctorDto);


}
