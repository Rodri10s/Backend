package br.edu.ifba.demo.backend.api.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import br.edu.ifba.demo.backend.api.model.LivroModel;
import lombok.Data;

@Data
public class LivroDTO implements Serializable {
    private Long id_livro;
    private String titulo;
    private String autor;
    private String editora;
    private Integer ano_publicacao;
    private String genero;
    private Integer isbn;
    private Integer num_paginas;
    private String sinopse;
    private String idioma;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime data_cadastro;
    private Double preco;

    public static LivroDTO converter(LivroModel livroModel) {
        var livro = new LivroDTO();
        livro.setId_livro(livroModel.getId_livro());
        livro.setTitulo(livroModel.getTitulo());
        livro.setAutor(livroModel.getAutor());
        livro.setEditora(livroModel.getEditora());
        livro.setAno_publicacao(livroModel.getAno_publicacao());
        livro.setGenero(livroModel.getGenero());
        livro.setIsbn(livroModel.getIsbn());
        livro.setNum_paginas(livroModel.getNum_paginas());
        livro.setSinopse(livroModel.getSinopse());
        livro.setIdioma(livroModel.getIdioma());
        livro.setData_cadastro(livroModel.getData_cadastro());
        livro.setPreco(livroModel.getPreco());
        return livro;
    }

    public static List<LivroDTO> converter(List<LivroModel> livros) {
        List<LivroDTO> list = new ArrayList<LivroDTO>();

        for (LivroModel model : livros) {
            list.add(LivroDTO.converter(model));
        }
        return list;
    }

}
