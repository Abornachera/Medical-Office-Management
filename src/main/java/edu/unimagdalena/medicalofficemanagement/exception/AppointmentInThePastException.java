package edu.unimagdalena.medicalofficemanagement.exception;

public class AppointmentInThePastException extends RuntimeException{
    public AppointmentInThePastException(String message) {
        super(message);
    }
}
