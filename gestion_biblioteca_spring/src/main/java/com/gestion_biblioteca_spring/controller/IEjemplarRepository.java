package com.gestion_biblioteca_spring.controller;

import com.gestion_biblioteca_spring.model.Ejemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEjemplarRepository extends JpaRepository<Ejemplar, Integer> {

}
