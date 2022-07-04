package com.example.pacotesTuristicos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pacotesTuristicos.model.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer>{

}
