package br.com.viccari.dev.resources.exception_handlers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.viccari.dev.exceptions.BadRequestException;

@Provider
public class BadRequestExceptionHandler extends ExceptionHandler implements ExceptionMapper<BadRequestException>{

    @Override
    public Response toResponse(BadRequestException exception) {
        return this.buildErrorResponse(exception);
    } 
}
