package com.gestion_biblioteca_spring.controller;

import com.gestion_biblioteca_spring.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, String> {
    Libro findLibroByIsbn(String isbn);

    void deleteLibroByIsbn(String isbn);
}
