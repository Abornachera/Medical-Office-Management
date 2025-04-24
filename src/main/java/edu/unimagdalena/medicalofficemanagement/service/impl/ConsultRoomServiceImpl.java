package edu.unimagdalena.medicalofficemanagement.service.impl;

import edu.unimagdalena.medicalofficemanagement.model.ConsultRoom;
import edu.unimagdalena.medicalofficemanagement.repository.ConsultRoomRepository;
import edu.unimagdalena.medicalofficemanagement.service.ConsultRoomService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultRoomServiceImpl implements ConsultRoomService {

    private final ConsultRoomRepository roomRepository;

    @Override
    public List<ConsultRoom> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<ConsultRoom> findById(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public ConsultRoom save(ConsultRoom room) {
        return roomRepository.save(room);
    }

    @Override
    public ConsultRoom update(Long id, ConsultRoom room) {
        ConsultRoom existing = roomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Room not found"));
        existing.setName(room.getName());
        existing.setFloor(room.getFloor());
        existing.setDescription(room.getDescription());
        return roomRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        roomRepository.deleteById(id);
    }
}
