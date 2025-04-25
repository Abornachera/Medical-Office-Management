package edu.unimagdalena.medicalofficemanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (name = "ConsultRooms")
public class ConsultRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int floor;

    @NotBlank
    @Column(nullable = false)
    private String description;

    @OneToMany (mappedBy = "consultRoom")
    private Set<Appointment> appointments;
}