package edu.unimagdalena.medicalofficemanagement.dto;

import lombok.Data;

@Data
public class ConsultRoomDTO {
    private Long id;
    private String name;
    private String floor;
    private String description;
}
