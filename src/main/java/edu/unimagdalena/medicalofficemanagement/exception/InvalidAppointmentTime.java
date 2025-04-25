package edu.unimagdalena.medicalofficemanagement.exception;

public class InvalidAppointmentTime extends RuntimeException {
    public InvalidAppointmentTime(String message) {
        super(message);
    }
}
