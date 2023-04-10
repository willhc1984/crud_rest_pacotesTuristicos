package com.example.pacotesTuristicos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pacotesTuristicos.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{

}
