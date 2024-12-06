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

import br.edu.ifba.demo.backend.api.repository.LivroRepository;
import br.edu.ifba.demo.backend.api.model.LivroModel;

@RestController
@RequestMapping("/Livro")
public class LivroController {

    private LivroRepository libRepository;

    public LivroController(LivroRepository libRepository) {
        super();
        this.libRepository = libRepository;
    }

    @PostMapping
    public ResponseEntity<LivroModel> addLivro(@RequestBody LivroModel livro) {
        LivroModel savedLivro = libRepository.save(livro);
        return new ResponseEntity<>(savedLivro, HttpStatus.CREATED);
    }

    @GetMapping("/listall")
    public List<LivroModel> listall() {
        var livros = libRepository.findAll();
        return livros;
    }

    @GetMapping("/getById/{id_livro}")
    public LivroModel getById(@PathVariable("id_livro") Long id_livro) {
        Optional<LivroModel> livro = libRepository.findById(id_livro);
        if (livro.isPresent())
            return livro.get();
        return null;
    }

    @GetMapping("/getByISBN/{isbn}")
    public LivroModel getByisbn(@PathVariable("isbn") Integer isbn) {
        Optional<LivroModel> livro = libRepository.findByIsbn(isbn);
        if (livro.isPresent())
            return livro.get();
        return null;
    }

    @GetMapping("/getByTittle/{titulo}")
    public LivroModel getByTittle(@PathVariable("titulo") String titulo) {
        Optional<LivroModel> livro = libRepository.findByTitulo(titulo);
        if (livro.isPresent())
            return livro.get();
        return null;
    }

    @DeleteMapping("/deleteLivro/{id_livro}")
    public ResponseEntity<LivroModel> deleteLivro(@PathVariable Long id_livro) {
        Optional<LivroModel> livro = libRepository.findById(id_livro);

        if (livro.isPresent()) {
            libRepository.delete(livro.get());
            System.out.println("Livro deletado com sucesso, ID: " + id_livro);
            return ResponseEntity.noContent().build();
        } else {
            System.out.println("Livro não encontrado, ID: " + id_livro);
            return ResponseEntity.notFound().build();
        }
    }

}
