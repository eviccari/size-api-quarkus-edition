package br.com.viccari.dev.resources.exception_handlers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.viccari.dev.exceptions.NotFoundException;

@Provider
public class NotFoundExceptionHandler extends ExceptionHandler implements ExceptionMapper<NotFoundException>{

    @Override
    public Response toResponse(NotFoundException exception) {
        return this.buildErrorResponse(exception);
    } 
}
