package br.com.viccari.dev.resources.exception_handlers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.viccari.dev.exceptions.UnprocessableEntityException;

@Provider
public class UnprocessableEntityExceptionHandler extends ExceptionHandler implements ExceptionMapper<UnprocessableEntityException>{

    @Override
    public Response toResponse(UnprocessableEntityException exception) {
        return this.buildErrorResponse(exception);
    } 
}
