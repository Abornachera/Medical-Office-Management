package edu.unimagdalena.medicalofficemanagement.service;

import edu.unimagdalena.medicalofficemanagement.model.ConsultRoom;

import java.util.List;
import java.util.Optional;

public interface ConsultRoomService {
    List<ConsultRoom> findAll();
    Optional<ConsultRoom> findById(Long id);
    ConsultRoom save(ConsultRoom room);
    ConsultRoom update(Long id, ConsultRoom room);
    void delete(Long id);
}
