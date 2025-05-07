package edu.unimagdalena.medicalofficemanagement.exception.notFound;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(String message) {
        super(message);
    }
}
