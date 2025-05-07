package edu.unimagdalena.medicalofficemanagement.service;


import edu.unimagdalena.medicalofficemanagement.dto.request.ConsultRoomDtoRequest;
import edu.unimagdalena.medicalofficemanagement.dto.response.ConsultRoomDtoResponse;

import java.util.List;

public interface ConsultRoomService {
    List<ConsultRoomDtoResponse> findAllConsultRooms();
    ConsultRoomDtoResponse findConsultRoomById(Long id);
    ConsultRoomDtoResponse saveConsultRoom(ConsultRoomDtoRequest consultRoomDtoRequest);
    ConsultRoomDtoResponse updateConsultRoom(Long id, ConsultRoomDtoRequest consultRoomDtoRequest);
    void deleteConsultRoom(Long id);
}
