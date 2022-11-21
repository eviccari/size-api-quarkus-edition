package br.com.viccari.dev.exceptions;

public class NotFoundException extends Exception implements HTTPException<Integer>{

    public static final Integer STATUS_CODE = 404;

    public NotFoundException() {
        super("not found");
    }

    public NotFoundException(String message) {
        super(message != null ? message: "not found");
    }

    @Override
    public Integer getStatusCode() {
        return STATUS_CODE;
    }
    
}
