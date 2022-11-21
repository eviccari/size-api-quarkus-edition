package br.com.viccari.dev.exceptions;

public class InternalServerErrorException extends Exception implements HTTPException<Integer>{

    public static final Integer STATUS_CODE = 500;

    public InternalServerErrorException(Throwable cause) {
        super(cause);
    }

    @Override
    public Integer getStatusCode() {
        return STATUS_CODE;
    }
    
}
