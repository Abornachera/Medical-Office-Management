package edu.unimagdalena.medicalofficemanagement.service;

import edu.unimagdalena.medicalofficemanagement.dto.request.DoctorDtoRequest;
import edu.unimagdalena.medicalofficemanagement.dto.response.DoctorDtoResponse;

import java.util.List;

public interface DoctorService {
    List<DoctorDtoResponse> findAllDoctors();
    DoctorDtoResponse findDoctorById(Long idDoctor);
    DoctorDtoResponse saveDoctor(DoctorDtoRequest doctorDtoRequest);
    DoctorDtoResponse updateDoctor(Long idDoctor, DoctorDtoRequest doctorDtoRequest);
    void deleteDoctor(Long idDoctor);
}
