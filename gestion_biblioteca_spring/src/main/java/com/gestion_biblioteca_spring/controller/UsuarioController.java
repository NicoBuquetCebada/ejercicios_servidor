package com.gestion_biblioteca_spring.controller;

import com.gestion_biblioteca_spring.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CacheConfig(cacheNames = "usuarios")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private IUsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Cacheable
    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        }
        return ResponseEntity.badRequest().body("Usuario no encontrado");
    }

    @PostMapping
    public ResponseEntity<?> guardar(@Validated @RequestBody Usuario usuario) {
        if (usuarioRepository.existsByDni(usuario.getDni()) || usuarioRepository.existsByEmail(usuario.getEmail())) { // Al ser autoincrement, no se da la posibilidad de introducir id, aun así se comprueba la duplicidad del dni y el email ya que el campo en la base de datos es único
            return ResponseEntity.badRequest().body("El usuario ya existe");
        }
        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }
}
