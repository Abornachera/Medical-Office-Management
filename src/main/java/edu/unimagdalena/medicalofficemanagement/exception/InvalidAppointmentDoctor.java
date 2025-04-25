package edu.unimagdalena.medicalofficemanagement.exception;

public class InvalidAppointmentDoctor extends RuntimeException {
    public InvalidAppointmentDoctor(String message) {
        super(message);
    }
}
