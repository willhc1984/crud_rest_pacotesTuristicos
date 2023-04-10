package com.example.pacotesTuristicos.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pacotesTuristicos.model.Compra;
import com.example.pacotesTuristicos.repositories.CompraRepository;

@Service
public class CompraService {
	
	@Autowired
	private CompraRepository compraRepository;

	public List<Compra> buscarTodos() {
		return compraRepository.findAll();
	}

	public Optional<Compra> buscarPorId(Long id) {
		return compraRepository.findById(id);
	}

	public Compra salvar(Compra compra) {
		
		return compraRepository.save(compra);
	}

}
