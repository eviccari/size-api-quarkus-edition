package br.com.viccari.dev.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseWithErrorDTO implements Serializable{

    @Getter
    @Setter
    String errorMessage;

    @Getter
    @Setter
    Integer statusCode;
}
