package edu.unimagdalena.medicalofficemanagement.exception.notFound;

public class AppointmentNotFoundException extends RuntimeException{
    public AppointmentNotFoundException(String message) {
        super(message);
    }
}
