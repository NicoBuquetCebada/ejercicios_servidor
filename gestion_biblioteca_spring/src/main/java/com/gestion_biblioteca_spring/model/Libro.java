package com.gestion_biblioteca_spring.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Libro {

    @Id
    @Column(name = "isbn", nullable = false, length = 20)
    @NotBlank(message = "no se acepta el campo vacío")
    @NotEmpty(message = "no se acepta el campo vacío")
    @NotNull(message = "no se acepta el campo nulo")
    @Pattern(regexp = "^97[89]-\\d{1,5}-\\d{1,7}-\\d{1,7}-\\d$", message = "formato no válido") // ISBN-13
    private String isbn;

   /* @Min(value = 1, message = "el valor minimo es 1")
    @NotNull(message = "el titulo no puede estar vacío") */
    @Pattern(regexp = "^(?!\\s*$).+", message = "no se acepta el campo vacío")
    @NotNull(message = "no se acepta el campo nulo")
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;


    @Column(name = "autor", nullable = false, length = 100)
    @Pattern(regexp = "^(?!\\s*$).+", message = "no se acepta el campo vacío")
    @NotNull(message = "no se acepta el campo nulo")
    private String autor;

    @OneToMany(mappedBy = "isbn")
    @JsonManagedReference("ejemplar-managed")
    private Set<Ejemplar> ejemplars = new LinkedHashSet<>();
    public Set<Ejemplar> getEjemplars() {
        return ejemplars;
    }

    public void setEjemplars(Set<Ejemplar> ejemplars) {
        this.ejemplars = ejemplars;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}