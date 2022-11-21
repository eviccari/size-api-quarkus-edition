package br.com.viccari.dev.exceptions;

public interface HTTPException<T> {
    T getStatusCode();
    String getMessage();
}
