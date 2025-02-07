package br.edu.ifba.demo.backend.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifba.demo.backend.api.model.GeneroModel;

@Repository
public interface GeneroRepository extends JpaRepository<GeneroModel, Long> {

    Optional<GeneroModel> findByNomeGenero(String nomeGenero);

}