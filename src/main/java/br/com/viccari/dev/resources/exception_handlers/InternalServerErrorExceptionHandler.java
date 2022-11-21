package br.com.viccari.dev.resources.exception_handlers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.viccari.dev.exceptions.InternalServerErrorException;

@Provider
public class InternalServerErrorExceptionHandler extends ExceptionHandler implements ExceptionMapper<InternalServerErrorException>{

    @Override
    public Response toResponse(InternalServerErrorException exception) {
        return this.buildErrorResponse(exception);
    } 
}
