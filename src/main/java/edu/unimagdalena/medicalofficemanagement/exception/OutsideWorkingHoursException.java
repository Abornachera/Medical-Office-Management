package edu.unimagdalena.medicalofficemanagement.exception;

public class OutsideWorkingHoursException extends RuntimeException{
    public OutsideWorkingHoursException(String message) {
        super(message);
    }
}
