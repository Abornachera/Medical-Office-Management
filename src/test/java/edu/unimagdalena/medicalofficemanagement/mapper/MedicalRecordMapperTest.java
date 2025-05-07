package edu.unimagdalena.medicalofficemanagement.mapper;

import edu.unimagdalena.medicalofficemanagement.dto.request.MedicalRecordDtoRequest;
import edu.unimagdalena.medicalofficemanagement.dto.response.MedicalRecordDtoResponse;
import edu.unimagdalena.medicalofficemanagement.model.Appointment;
import edu.unimagdalena.medicalofficemanagement.model.MedicalRecord;
import edu.unimagdalena.medicalofficemanagement.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;

class MedicalRecordMapperTest {

    private MedicalRecordMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(MedicalRecordMapper.class); //Esto busca la implementación generada por MapStruct automáticamente en tiempo de ejecución.
    }

    @Test
    void toMedicalRecordDtoResponse_shouldMapAllFields() {
        Patient patient = Patient.builder().idPatient(1L).build();
        Appointment appointment = Appointment.builder().idAppointment(2L).build();
        LocalDateTime createdAt = LocalDateTime.of(2024, 5, 1, 14, 30);
        MedicalRecord record = MedicalRecord.builder()
                .idMedicalRecord(100L)
                .patient(patient)
                .appointment(appointment)
                .diagnosis("Hipertensión arterial")
                .notes("Control cada 3 meses")
                .createdAt(createdAt)
                .build();

        MedicalRecordDtoResponse dto = mapper.toMedicalRecordDtoResponse(record);

        assertThat(dto.idMedicalRecord()).isEqualTo(record.getIdMedicalRecord());
        assertThat(dto.idPatient()).isEqualTo(record.getPatient().getIdPatient());
        assertThat(dto.idAppointment()).isEqualTo(record.getAppointment().getIdAppointment());
        assertThat(dto.diagnosis()).isEqualTo(record.getDiagnosis());
        assertThat(dto.notes()).isEqualTo(record.getNotes());
        assertThat(dto.createdAt()).isEqualTo(record.getCreatedAt());
    }

    @Test
    void toEntity_shouldMapFieldsExceptIdAndRelations() {
        LocalDateTime createdAt = LocalDateTime.of(2024, 5, 2, 10, 15);
        MedicalRecordDtoRequest dtoRequest = new MedicalRecordDtoRequest(
                3L,
                4L,
                "Diabetes tipo II",
                "Revisión trimestral de glucemia",
                createdAt
        );

        MedicalRecord entity = mapper.toEntity(dtoRequest);

        assertThat(entity.getIdMedicalRecord()).isNull();
        assertThat(entity.getPatient()).isNull();
        assertThat(entity.getAppointment()).isNull();
        assertThat(entity.getDiagnosis()).isEqualTo(dtoRequest.diagnosis());
        assertThat(entity.getNotes()).isEqualTo(dtoRequest.notes());
        assertThat(entity.getCreatedAt()).isEqualTo(dtoRequest.createdAt());
    }
}
