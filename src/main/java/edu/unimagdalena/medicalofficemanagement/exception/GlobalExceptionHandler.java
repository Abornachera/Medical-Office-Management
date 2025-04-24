package edu.unimagdalena.medicalofficemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            DoctorNotFoundException.class,
            PatientNotFoundException.class,
            ConsultRoomNotFoundException.class,
            AppointmentNotFoundException.class,
            MedicalRecordNotFoundException.class
    })
    public ResponseEntity<ApiError> handleNotFound(RuntimeException ex) {
        return new ResponseEntity<>(new ApiError(HttpStatus.NOT_FOUND, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AppointmentAlreadyExistException.class)
    public ResponseEntity<ApiError> handleConflict(AppointmentAlreadyExistException ex) {
        return new ResponseEntity<>(new ApiError(HttpStatus.CONFLICT, ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneral(Exception ex) {
        return new ResponseEntity<>(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Error inesperado"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
