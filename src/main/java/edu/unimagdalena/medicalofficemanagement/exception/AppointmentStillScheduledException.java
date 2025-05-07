package edu.unimagdalena.medicalofficemanagement.exception;

public class AppointmentStillScheduledException extends RuntimeException{
    public AppointmentStillScheduledException(String message) {
        super(message);
    }
}
