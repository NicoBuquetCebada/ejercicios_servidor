package com.gestion_biblioteca_spring.controller;

import com.gestion_biblioteca_spring.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final ILibroRepository libroRepository;

    @Autowired
    public LibroController(ILibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @GetMapping("/{isbn}") // Permite aceptar un parametro en la url del endpoint
    public ResponseEntity<Libro> getLibro(@PathVariable String isbn) {
        return ResponseEntity.ok(libroRepository.findLibroByIsbn(isbn));
    }

    @GetMapping
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Libro> addLibro(@RequestBody Libro libro) {
        return ResponseEntity.ok(libroRepository.save(libro));
    }

    @Transactional
    @DeleteMapping("/{isbn}")
    public void deleteLibro(@PathVariable String isbn) {
        libroRepository.deleteLibroByIsbn(isbn);
    }

    @PutMapping("/update")
    public ResponseEntity<Libro> updateLibro(@RequestBody Libro libro) {
        return ResponseEntity.ok(libroRepository.save(libro));
    }

}
