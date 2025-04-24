package edu.unimagdalena.medicalofficemanagement.controller;

import edu.unimagdalena.medicalofficemanagement.dto.ConsultRoomDTO;
import edu.unimagdalena.medicalofficemanagement.mapper.ConsultRoomMapper;
import edu.unimagdalena.medicalofficemanagement.service.ConsultRoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class ConsultRoomController {

    private final ConsultRoomService roomService;
    private final ConsultRoomMapper roomMapper;

    @GetMapping
    public List<ConsultRoomDTO> findAll() {
        return roomService.findAll().stream().map(roomMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultRoomDTO> findById(@PathVariable Long id) {
        return roomService.findById(id)
                .map(roomMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ConsultRoomDTO> create(@Valid @RequestBody ConsultRoomDTO dto) {
        return ResponseEntity.ok(roomMapper.toDto(roomService.save(roomMapper.toEntity(dto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultRoomDTO> update(@PathVariable Long id, @Valid @RequestBody ConsultRoomDTO dto) {
        return ResponseEntity.ok(roomMapper.toDto(roomService.update(id, roomMapper.toEntity(dto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        roomService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
