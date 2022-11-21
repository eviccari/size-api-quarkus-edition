package br.com.viccari.dev.resources.exception_handlers;

import javax.ws.rs.core.Response;

import br.com.viccari.dev.dtos.ResponseWithErrorDTO;
import br.com.viccari.dev.exceptions.HTTPException;

public class ExceptionHandler {

    public Response buildErrorResponse(HTTPException<Integer> exception) {
        return Response
            .status(exception.getStatusCode())
            .entity(
                ResponseWithErrorDTO
                    .builder()
                    .statusCode(exception.getStatusCode())
                    .errorMessage(exception.getMessage())
                    .build()
            ).build();
    } 
    
}
