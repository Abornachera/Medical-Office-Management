package edu.unimagdalena.medicalofficemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Data
@NoArgsConstructor
@Builder
public class Patient {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String nombre;

    @Email
    @NotBlank
    private String email;

    private String phone;

    private ArrayList historial =new ArrayList();

}

//Datos del paciente (nombre, email, teléfono, historial)