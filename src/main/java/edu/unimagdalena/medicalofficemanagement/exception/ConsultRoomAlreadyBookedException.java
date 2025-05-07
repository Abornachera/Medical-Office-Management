package edu.unimagdalena.medicalofficemanagement.exception;

public class ConsultRoomAlreadyBookedException extends RuntimeException{
    public ConsultRoomAlreadyBookedException(String message) {
        super(message);
    }
}
