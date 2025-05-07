package edu.unimagdalena.medicalofficemanagement.service.impl;

import edu.unimagdalena.medicalofficemanagement.dto.request.ConsultRoomDtoRequest;
import edu.unimagdalena.medicalofficemanagement.dto.response.ConsultRoomDtoResponse;
import edu.unimagdalena.medicalofficemanagement.exception.notFound.ConsultRoomNotFoundException;
import edu.unimagdalena.medicalofficemanagement.repository.ConsultRoomRepository;
import edu.unimagdalena.medicalofficemanagement.mapper.ConsultRoomMapper;
import edu.unimagdalena.medicalofficemanagement.model.ConsultRoom;
import edu.unimagdalena.medicalofficemanagement.service.ConsultRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultRoomServiceImpl implements ConsultRoomService {

    private ConsultRoomRepository consultRoomRepository;
    private ConsultRoomMapper consultRoomMapper;

    @Override
    public List<ConsultRoomDtoResponse> findAllConsultRooms() {
        return consultRoomRepository.findAll().stream()
                .map(consultRoomMapper::toConsultRoomDtoResponse)
                .toList();
    }

    @Override
    public ConsultRoomDtoResponse findConsultRoomById(Long id) {
        ConsultRoom consultRoom = consultRoomRepository.findById(id)
                .orElseThrow(() -> new ConsultRoomNotFoundException("Consult Room with ID: " + id + " Not Found"));

        return consultRoomMapper.toConsultRoomDtoResponse(consultRoom);
    }

    @Override
    public ConsultRoomDtoResponse saveConsultRoom(ConsultRoomDtoRequest consultRoomDtoRequest) {
        ConsultRoom toBeSaved = consultRoomMapper.toEntity(consultRoomDtoRequest);
        return consultRoomMapper.toConsultRoomDtoResponse(consultRoomRepository.save(toBeSaved));
    }

    @Override
    public ConsultRoomDtoResponse updateConsultRoom(Long id, ConsultRoomDtoRequest consultRoomDtoRequest) {
        ConsultRoom consultRoom = consultRoomRepository.findById(id)
                .orElseThrow(() -> new ConsultRoomNotFoundException("Consult Room with ID: " + id + " Not Found"));

        consultRoomMapper.updateConsultRoomFromDto(consultRoomDtoRequest, consultRoom);

        return consultRoomMapper.toConsultRoomDtoResponse(consultRoomRepository.save(consultRoom));

    }

    @Override
    public void deleteConsultRoom(Long id) {

        if(!consultRoomRepository.existsById(id)){
            throw new ConsultRoomNotFoundException("Consult Room with ID: " + id + " Not Found");
        }

        consultRoomRepository.deleteById(id);
    }

}