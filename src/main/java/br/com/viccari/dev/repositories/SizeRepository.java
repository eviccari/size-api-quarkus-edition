package br.com.viccari.dev.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.viccari.dev.dtos.SizeDTO;

public class SizeRepository implements Repository<SizeDTO>{

    private List<SizeDTO> dtos = new ArrayList<>();

    @Override
    public void create(SizeDTO instance) {
        dtos.add(instance);
    }

    @Override
    public SizeDTO findById(String id) {
        var optional = dtos.stream().filter(d -> d.getId().equals(id)).findFirst();

        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @Override
    public List<SizeDTO> all() {
        return dtos;
    }

    @Override
    public int delete(String id) {
        for (int i = 0; i < this.dtos.size(); i++) {
            if(this.dtos.get(i).getId().equals(id)){
                this.dtos.remove(i);
                return 1;
            }
        }
        return 0;
    }
}
