package edu.unimagdalena.medicalofficemanagement.exception;

public class AppointmentAlreadyCompletedException extends RuntimeException{
    public AppointmentAlreadyCompletedException(String message) {
        super(message);
    }
}
