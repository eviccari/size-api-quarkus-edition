package br.com.viccari.dev.services;

import br.com.viccari.dev.dtos.SizeDTO;
import br.com.viccari.dev.exceptions.InternalServerErrorException;
import br.com.viccari.dev.exceptions.UnprocessableEntityException;
import br.com.viccari.dev.models.Size.CreateService;
import br.com.viccari.dev.repositories.Repository;
import br.com.viccari.dev.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateSizeService implements CreateService<SizeDTO>{

    Repository<SizeDTO> repository;

    public CreateSizeService(Repository<SizeDTO> repository) {
        this.repository = repository;
    }

    @Override
    public String create(SizeDTO instance) throws UnprocessableEntityException, InternalServerErrorException{
        log.info(String.format("payload-> %s",instance.toString()));
        var model = ObjectUtils.convertFrom(instance);
        model.generateId();
        model.validate();

        instance.setId(model.getId());
        this.repository.create(instance);        
        log.info(String.format("generated id-> %s", model.getId()));

        return model.getId();    
    }    
}
