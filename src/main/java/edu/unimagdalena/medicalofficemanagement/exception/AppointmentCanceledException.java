package edu.unimagdalena.medicalofficemanagement.exception;

public class AppointmentCanceledException extends RuntimeException{
    public AppointmentCanceledException(String message) {
        super(message);
    }
}
