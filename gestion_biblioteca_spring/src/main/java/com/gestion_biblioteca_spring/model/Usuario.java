package com.gestion_biblioteca_spring.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Usuario {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dni", nullable = false, length = 15)
    @Pattern(regexp = "^[0-9]{8}[A-Za-z]+$", message = "Formato incorrecto")
    private String dni;

    @Column(name = "nombre", nullable = false, length = 100)
    @Pattern(regexp = "^[a-zA-Z]{3,20}$", message = "Formato incorrecto")
    private String nombre;

    @Column(name = "email", nullable = false, length = 100)
    @Pattern(regexp = "^[A-Za-z0-9.,]{1,50}@gmail.com$", message = "Formato incorrecto")
    private String email;

    @Column(name = "password", nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9]{4,12}$", message = "Formato incorrecto")
    private String password;

    @Lob
    @Column(name = "tipo", nullable = false)
    @Pattern(regexp = "^(normal|administrador)$", message = "Formato incorrecto")
    private String tipo;

    @Column(name = "penalizacionHasta")
    private LocalDate penalizacionHasta;

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getPenalizacionHasta() {
        return penalizacionHasta;
    }

    public void setPenalizacionHasta(LocalDate penalizacionHasta) {
        this.penalizacionHasta = penalizacionHasta;
    }

}