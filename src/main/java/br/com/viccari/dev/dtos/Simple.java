package br.com.viccari.dev.dtos;

import java.io.Serializable;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Simple implements Serializable{

    @Getter
    @Setter
    private String id;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }   
}
