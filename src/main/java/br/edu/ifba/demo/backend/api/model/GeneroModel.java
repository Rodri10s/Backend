package br.edu.ifba.demo.backend.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "genero")
@Data
public class GeneroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_genero;

    @Column(name = "nome_genero")
    private String nomeGenero;

    @Column(columnDefinition = "BIT(1)")
    private Boolean status;

    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<LivroModel> livros;
}
