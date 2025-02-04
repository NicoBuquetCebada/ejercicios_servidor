package com.gestion_biblioteca_spring.controller;

import com.gestion_biblioteca_spring.model.Libro;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
@CacheConfig(cacheNames = {"libro"})
public class LibroController {

    private final ILibroRepository libroRepository;

    @Autowired
    public LibroController(ILibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @GetMapping("/{isbn}") // Permite aceptar un parametro en la url del endpoint
    @Cacheable // Guarda resultados en cache
    public ResponseEntity<Libro> getLibro(@PathVariable String isbn) {
        try {
            Thread.sleep(3000); // Para diferenciar si obtiene el resultado de la cache o de la base de datos (dependencias en el pom y bean en la app)
            return ResponseEntity.ok(libroRepository.findLibroByIsbn(isbn));
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addLibro(@Valid @RequestBody Libro libro) { // Se añade el valid para que hibernate gestione las validaciones del DTO
        return ResponseEntity.ok(libroRepository.save(libro));
    }

    @Transactional
    @DeleteMapping("/{isbn}")
    public void deleteLibro(@PathVariable String isbn) {
        libroRepository.deleteLibroByIsbn(isbn);
    }

    @PutMapping("/update")
    public ResponseEntity<Libro> updateLibro(@Valid @RequestBody Libro libro) {
        return ResponseEntity.ok(libroRepository.save(libro));
    }

}
