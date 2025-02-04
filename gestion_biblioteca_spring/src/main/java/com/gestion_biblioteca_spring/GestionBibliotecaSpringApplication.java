package com.gestion_biblioteca_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GestionBibliotecaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionBibliotecaSpringApplication.class, args);
    }
}
