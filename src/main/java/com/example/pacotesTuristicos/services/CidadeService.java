package com.example.pacotesTuristicos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pacotesTuristicos.model.Cidade;
import com.example.pacotesTuristicos.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
	
	public List<Cidade> buscarTodos(){
		List<Cidade> cidades = repository.findAll();
		return cidades;
	}
	
	public Cidade buscarPorId(Integer id) {
		Optional<Cidade> cidade = repository.findById(id);
		return cidade.get();
	}
	
	public Cidade salvar(Cidade cidade) {
		return repository.save(cidade);
	}
	
	public void apagar(Integer id) {
		repository.deleteById(id);
	}
	
	public Cidade atualizar(Integer id, Cidade cidade) {
		Cidade obj = repository.getOne(id);
		updateData(obj, cidade);
		return repository.save(obj);
	}

	private void updateData(Cidade obj, Cidade cidade) {
		obj.setNome(cidade.getNome());
		obj.setEstado(cidade.getEstado());
		obj.setWebsite(cidade.getWebsite());
	}
	
}
