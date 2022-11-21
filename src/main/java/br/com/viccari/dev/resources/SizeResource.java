package br.com.viccari.dev.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import br.com.viccari.dev.dtos.SizeDTO;
import br.com.viccari.dev.exceptions.BadRequestException;
import br.com.viccari.dev.exceptions.InternalServerErrorException;
import br.com.viccari.dev.exceptions.NotFoundException;
import br.com.viccari.dev.exceptions.UnprocessableEntityException;
import br.com.viccari.dev.models.Size.CreateService;
import br.com.viccari.dev.repositories.Repository;
import br.com.viccari.dev.repositories.SizeRepository;
import br.com.viccari.dev.services.CreateSizeService;
import br.com.viccari.dev.services.FindSizeByIdService;

@Path("/api/v1/sizes")
public class SizeResource {

    CreateService<SizeDTO> service;
    Repository<SizeDTO> repository;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(SizeDTO dto) throws UnprocessableEntityException, InternalServerErrorException {
        var generated = new CreateSizeService(this.getRepositoryInstance()).create(dto);

        return Response.created(
            UriBuilder
                .fromResource(SizeResource.class)
                .path(generated)
                .build()
            ).entity(dto)
        .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findById(@PathParam("id") String id) throws InternalServerErrorException, BadRequestException, NotFoundException {
        var dto = new FindSizeByIdService(this.getRepositoryInstance()).findById(id);
        return Response.ok().entity(dto).build();
    }

    public Repository<SizeDTO> getRepositoryInstance() {
        if(this.repository == null) {
            this.repository = new SizeRepository();
        }
        return this.repository;
    }
}