package edu.unimagdalena.medicalofficemanagement.service.impl;

import edu.unimagdalena.medicalofficemanagement.dto.request.DoctorDtoRequest;
import edu.unimagdalena.medicalofficemanagement.dto.response.DoctorDtoResponse;
import edu.unimagdalena.medicalofficemanagement.exception.notFound.DoctorNotFoundException;
import edu.unimagdalena.medicalofficemanagement.repository.DoctorRepository;
import edu.unimagdalena.medicalofficemanagement.mapper.DoctorMapper;
import edu.unimagdalena.medicalofficemanagement.model.Doctor;
import edu.unimagdalena.medicalofficemanagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorServiceImpl(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public List<DoctorDtoResponse> findAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(doctorMapper::toDoctorDtoResponse)
                .toList();
    }

    @Override
    public DoctorDtoResponse findDoctorById(Long idDoctor) {
        Doctor doctor = doctorRepository.findById(idDoctor)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor with ID: " + idDoctor + " not found"));

        return doctorMapper.toDoctorDtoResponse(doctor);
    }

    @Override
    public DoctorDtoResponse saveDoctor(DoctorDtoRequest doctorDtoRequest) {
        Doctor doctor = doctorMapper.toEntity(doctorDtoRequest);
        return doctorMapper.toDoctorDtoResponse(doctorRepository.save(doctor));
    }

    @Override
    public DoctorDtoResponse updateDoctor(Long idDoctor, DoctorDtoRequest doctorDtoRequest) {
        Doctor doctor = doctorRepository.findById(idDoctor)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor with ID: " + idDoctor + " not found"));

        doctor.setFullName(doctorDtoRequest.fullName());
        doctor.setEmail(doctorDtoRequest.email());
        doctor.setSpeciality(doctorDtoRequest.speciality());
        doctor.setAvailableFrom(doctorDtoRequest.availableFrom());
        doctor.setAvailableTo(doctorDtoRequest.availableTo());

        return doctorMapper.toDoctorDtoResponse(doctorRepository.save(doctor));
    }

    @Override
    public void deleteDoctor(Long idDoctor) {

        if(!doctorRepository.existsById(idDoctor)){
            throw new DoctorNotFoundException("Doctor with ID: " + idDoctor + " not found");
        }

        doctorRepository.deleteById(idDoctor);

    }
}