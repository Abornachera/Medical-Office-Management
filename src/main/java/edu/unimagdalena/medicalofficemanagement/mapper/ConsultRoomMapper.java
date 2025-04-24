package edu.unimagdalena.medicalofficemanagement.mapper;

import edu.unimagdalena.medicalofficemanagement.dto.ConsultRoomDTO;
import edu.unimagdalena.medicalofficemanagement.model.ConsultRoom;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConsultRoomMapper {
    ConsultRoomDTO toDto(ConsultRoom room);
    ConsultRoom toEntity(ConsultRoomDTO dto);
}
