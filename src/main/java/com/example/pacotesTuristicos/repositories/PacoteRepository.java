package com.example.pacotesTuristicos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pacotesTuristicos.model.Pacote;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Integer>{
	
	List<Pacote> findByCidade_Nome(String nome);

}
