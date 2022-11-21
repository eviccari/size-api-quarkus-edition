package br.com.viccari.dev.utils;

import br.com.viccari.dev.dtos.SizeDTO;
import br.com.viccari.dev.models.Size;

public class ObjectUtils {
    
    private ObjectUtils(){}

    public static final Size convertFrom(SizeDTO dto) {
        return Size.builder()
            .description(dto.getDescription())
            .shortDescription(dto.getShortDescription())
            .sizeRange(dto.getSizeRange())
        .build();
    }
}
