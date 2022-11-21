package br.com.viccari.dev.models;

import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;

import br.com.viccari.dev.exceptions.BadRequestException;
import br.com.viccari.dev.exceptions.InternalServerErrorException;
import br.com.viccari.dev.exceptions.NotFoundException;
import br.com.viccari.dev.exceptions.UnprocessableEntityException;
import br.com.viccari.dev.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
public class Size implements Identifiable, Validatable{
    
    @Getter
    @Setter
    private String id;
    
    @Getter
    @Setter
    private String description;
    
    @Getter
    @Setter
    private String shortDescription;
    
    @Getter
    @Setter
    private String sizeRange;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    @Override
    public void generateId() {
        this.id = UUID.randomUUID().toString();        
    }

    @Override
    public void validate() throws UnprocessableEntityException {
        if(StringUtils.isEmpty(this.id)) 
            throw new UnprocessableEntityException("id is required");

        if(StringUtils.isEmpty(this.description)) 
            throw new UnprocessableEntityException("description is required");

        if(StringUtils.isEmpty(this.shortDescription)) 
            throw new UnprocessableEntityException("shortDescription is required");

        if(StringUtils.isEmpty(this.sizeRange)) 
            throw new UnprocessableEntityException("sizeRange is required");
    }

    public interface CreateService<T> {
        /**
         * Must create new Size into repository
         * @param instance
         * @return Generated ID
         */
        String create(T instance) throws UnprocessableEntityException, InternalServerErrorException;
    }

    public interface FindByIdService<T> {
        /**
         * Must find Size instance using given id
         * @param id
         * @return Size instance from repository
         */
        T findById(String id) throws InternalServerErrorException, BadRequestException, NotFoundException;
    }

    public interface All<T> {
        /**
         * Must get all sizes from repository
         * @return List of sizes
         */
        List<T> findAll();
    }

    public interface UpdateService<T> {
        /**
         * Must update size data into repository
         * @param instance
         * @return updated row count
         */
        int update(T instance);
    }

    public interface DeleteService {
        /**
         * Must delete size from repository using given id`
         * @param id
         * @return updated row count
         */
        int delete(String id);
    }
}
