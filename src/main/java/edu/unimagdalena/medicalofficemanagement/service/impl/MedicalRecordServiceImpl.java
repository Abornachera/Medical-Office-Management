package edu.unimagdalena.medicalofficemanagement.service.impl;

import edu.unimagdalena.medicalofficemanagement.dto.request.MedicalRecordDtoRequest;
import edu.unimagdalena.medicalofficemanagement.dto.response.MedicalRecordDtoResponse;
import edu.unimagdalena.medicalofficemanagement.exception.AppointmentCanceledException;
import edu.unimagdalena.medicalofficemanagement.exception.AppointmentStillScheduledException;
import edu.unimagdalena.medicalofficemanagement.exception.notFound.AppointmentNotFoundException;
import edu.unimagdalena.medicalofficemanagement.exception.notFound.MedicalRecordNotFoundException;
import edu.unimagdalena.medicalofficemanagement.exception.notFound.PatientNotFoundException;
import edu.unimagdalena.medicalofficemanagement.repository.AppointmentRepository;
import edu.unimagdalena.medicalofficemanagement.repository.ConsultRoomRepository;
import edu.unimagdalena.medicalofficemanagement.repository.MedicalRecordRepository;
import edu.unimagdalena.medicalofficemanagement.repository.PatientRepository;
import edu.unimagdalena.medicalofficemanagement.mapper.MedicalRecordMapper;
import edu.unimagdalena.medicalofficemanagement.model.Appointment;
import edu.unimagdalena.medicalofficemanagement.model.AppointmentStatus;
import edu.unimagdalena.medicalofficemanagement.model.MedicalRecord;
import edu.unimagdalena.medicalofficemanagement.model.Patient;
import edu.unimagdalena.medicalofficemanagement.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final ConsultRoomRepository consultRoomRepository;
    private MedicalRecordRepository medicalRecordRepository;
    private PatientRepository patientRepository;
    private AppointmentRepository appointmentRepository;
    private MedicalRecordMapper medicalRecordMapper;


    @Override
    public List<MedicalRecordDtoResponse> findAllMedicalRecords() {
        return medicalRecordRepository.findAll().stream()
                .map(medicalRecordMapper::toMedicalRecordDtoResponse)
                .toList();
    }

    @Override
    public MedicalRecordDtoResponse findById(Long id) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(id)
                .orElseThrow(() -> new MedicalRecordNotFoundException("Medical Record with ID: " + id + " Not Found"));

        return medicalRecordMapper.toMedicalRecordDtoResponse(medicalRecord);

    }

    @Override
    public List<MedicalRecordDtoResponse> findMedicalRecordsByPatient(Long id) {

        if(!patientRepository.existsById(id)){
            throw new PatientNotFoundException("Patient with ID: " + id + " Not Found");
        }

        List<MedicalRecordDtoResponse> result = medicalRecordRepository.findByPatientId(id).stream()
                .map(medicalRecordMapper::toMedicalRecordDtoResponse)
                .toList();

        return result;
    }

    @Override
    public MedicalRecordDtoResponse saveMedicalRecord(MedicalRecordDtoRequest medicalRecordDtoRequest) {

        Patient patient = patientRepository.findById(medicalRecordDtoRequest.idPatient())
                .orElseThrow(() -> new PatientNotFoundException("Patient with ID: " + medicalRecordDtoRequest.idPatient() + " Not Found"));

        Appointment appointment = appointmentRepository.findById(medicalRecordDtoRequest.idAppointment())
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment with ID: " + medicalRecordDtoRequest.idAppointment() + " Not Found"));

        if(appointment.getStatus() == AppointmentStatus.SCHEDULED){
            throw new AppointmentStillScheduledException("Appointment's status is Scheduled");
        }

        if(appointment.getStatus() == AppointmentStatus.CANCELED){
            throw new AppointmentCanceledException("Appointment has been canceled");
        }

        MedicalRecord medicalRecord = medicalRecordMapper.toEntity(medicalRecordDtoRequest);
        medicalRecord.setPatient(patient);
        medicalRecord.setAppointment(appointment);

        MedicalRecord savedEntity = medicalRecordRepository.save(medicalRecord);
        return medicalRecordMapper.toMedicalRecordDtoResponse(savedEntity);

    }

    @Override
    public void deleteMedicalRecord(Long id) {

        if(!medicalRecordRepository.existsById(id)){
            throw new MedicalRecordNotFoundException("Medical Record with ID: " + id + " Not Found");
        }

        medicalRecordRepository.deleteById(id);

    }
}