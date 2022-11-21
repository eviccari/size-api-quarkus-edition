package br.com.viccari.dev.services;

import br.com.viccari.dev.dtos.SizeDTO;
import br.com.viccari.dev.exceptions.BadRequestException;
import br.com.viccari.dev.exceptions.InternalServerErrorException;
import br.com.viccari.dev.exceptions.NotFoundException;
import br.com.viccari.dev.models.Size.FindByIdService;
import br.com.viccari.dev.repositories.Repository;
import br.com.viccari.dev.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindSizeByIdService implements FindByIdService<SizeDTO>{

    public static final String ID_REQUIRED_MESSAGE = "id is required";

    Repository<SizeDTO> repository;

    public FindSizeByIdService(Repository<SizeDTO> repository) {
        this.repository = repository;
    }

    @Override
    public SizeDTO findById(String id) throws InternalServerErrorException, BadRequestException, NotFoundException {
        if(StringUtils.isEmpty(id))
            throw new BadRequestException(ID_REQUIRED_MESSAGE);

        log.info(String.format("id->%s", id));    
        var result =  this.repository.findById(id);
        if(result != null) {
            return result;
        } else {
            throw new NotFoundException();
        }
    }
}
