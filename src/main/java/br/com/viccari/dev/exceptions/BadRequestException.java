package br.com.viccari.dev.exceptions;

public class BadRequestException extends Exception implements HTTPException<Integer>{

    public static final Integer STATUS_CODE = 400;

    public BadRequestException(String message) {
        super(message);
    }

    @Override
    public Integer getStatusCode() {
        return STATUS_CODE;
    }
    
}
