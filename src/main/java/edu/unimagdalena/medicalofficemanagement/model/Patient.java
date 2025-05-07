package edu.unimagdalena.medicalofficemanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "patient")
    private List<MedicalRecord> medicalRecords;

    @Column(nullable = false)
    @NotBlank
    private String fullName;

    @Column(nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    @NotNull
    private String phone;

}