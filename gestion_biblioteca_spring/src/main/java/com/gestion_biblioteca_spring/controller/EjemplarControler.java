package com.gestion_biblioteca_spring.controller;

import com.gestion_biblioteca_spring.model.Ejemplar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ejemplares")
public class EjemplarControler {
    private final IEjemplarRepository repository;
    private final ILibroRepository libroRepository;

    @Autowired
    public EjemplarControler(IEjemplarRepository repository, ILibroRepository libroRepository) {
        this.repository = repository;
        this.libroRepository = libroRepository;
    }

    @GetMapping
    public List<Ejemplar> getAllLibros() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ejemplar> getLibro(@PathVariable Integer id) {
        return ResponseEntity.ok(repository.findById(id).orElse(null));
    }

    @PostMapping
    public ResponseEntity<Ejemplar> addLibro(@Validated @RequestBody Map<String, Object> body) {
        //Integer id = (Integer)body.get("id");
        String isbn = (String)body.get("isbn");
        String estado = (String)body.get("estado");

        Ejemplar ejemplar  = new Ejemplar();
        //ejemplar.setId(id);
        ejemplar.setEstado(estado);
        ejemplar.setIsbn(libroRepository.findLibroByIsbn(isbn));

        return ResponseEntity.ok(repository.save(ejemplar));
    }

    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PutMapping
    public ResponseEntity<Ejemplar> updateLibro(@RequestBody Ejemplar libro) {
        return ResponseEntity.ok(repository.save(libro));
    }
}
