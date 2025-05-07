package edu.unimagdalena.medicalofficemanagement.exception.notFound;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(String message) {
        super(message);
    }
}
