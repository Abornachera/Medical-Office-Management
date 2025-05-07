package edu.unimagdalena.medicalofficemanagement.mapper;

import edu.unimagdalena.medicalofficemanagement.dto.request.ConsultRoomDtoRequest;
import edu.unimagdalena.medicalofficemanagement.dto.response.ConsultRoomDtoResponse;
import edu.unimagdalena.medicalofficemanagement.model.ConsultRoom;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ConsultRoomMapper {

    @Mapping(source = "idConsultRoom", target = "id")
    ConsultRoomDtoResponse toConsultRoomDtoResponse(ConsultRoom consultRoom);

    ConsultRoom toEntity(ConsultRoomDtoRequest consultRoomDto);

    void updateConsultRoomFromDto(ConsultRoomDtoRequest dto, @MappingTarget ConsultRoom consultRoom);
}
