package edu.unimagdalena.medicalofficemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsultRoomDTO {
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String floor;

    private String description;
}
