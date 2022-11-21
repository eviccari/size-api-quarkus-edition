package br.com.viccari.dev.models;

import br.com.viccari.dev.exceptions.UnprocessableEntityException;

public interface Validatable {
    void validate() throws UnprocessableEntityException;
}
