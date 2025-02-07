package br.edu.ifba.demo.backend.api.dto;

import java.io.Serializable;

import br.edu.ifba.demo.backend.api.model.GeneroModel;
import lombok.Data;

@Data
public class GeneroDTO implements Serializable {

    private Long id_genero;
    private String nomeGenero;
    private Boolean status;

    public static GeneroDTO converter(GeneroModel generoModel) {
        var genero = new GeneroDTO();
        genero.setId_genero(generoModel.getId_genero());
        genero.setNomeGenero(generoModel.getNomeGenero());
        genero.setStatus(generoModel.getStatus());
        return genero;
    }

}
