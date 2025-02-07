package br.edu.ifba.demo.backend.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.demo.backend.api.model.GeneroModel;
import br.edu.ifba.demo.backend.api.repository.GeneroRepository;

@RestController
@RequestMapping("/Genero")
public class GeneroController {

    private GeneroRepository generoRepository;

    public GeneroController(GeneroRepository generoRepository) {
        super();
        this.generoRepository = generoRepository;
    }

    @PostMapping
    public ResponseEntity<GeneroModel> addGenero(@RequestBody GeneroModel genero) {
        GeneroModel savedGenero = generoRepository.save(genero);
        return new ResponseEntity<>(savedGenero, HttpStatus.CREATED);
    }

    @GetMapping("/listall")
    public List<GeneroModel> listall() {
        var generos = generoRepository.findAll();
        return generos;
    }

    @GetMapping("/getById/{id_genero}")
    public GeneroModel getById(@PathVariable("id_genero") Long id_genero) {
        Optional<GeneroModel> genero = generoRepository.findById(id_genero);
        if (genero.isPresent())
            return genero.get();
        return null;
    }

    @GetMapping("/getByName/{nome_genero}")
    public GeneroModel getByNome(@PathVariable("nome_genero") String nome_genero) {
        Optional<GeneroModel> genero = generoRepository.findByNomeGenero(nome_genero);
        if (genero.isPresent())
            return genero.get();
        return null;
    }

    @DeleteMapping("/deleteGenero/{id_genero}")
    public ResponseEntity<GeneroModel> deleteGenero(@PathVariable Long id_genero) {
        Optional<GeneroModel> genero = generoRepository.findById(id_genero);

        if (genero.isPresent()) {
            generoRepository.delete(genero.get());
            System.out.println("Genero deletado com sucesso, ID: " + id_genero);
            return ResponseEntity.noContent().build();
        } else {
            System.out.println("Genero não encontrado, ID: " + id_genero);
            return ResponseEntity.notFound().build();
        }
    }

}
