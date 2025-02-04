package com.gestion_biblioteca_spring.controller;

import com.gestion_biblioteca_spring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsByDni(String dni);

    boolean existsByEmail(String email);
}
