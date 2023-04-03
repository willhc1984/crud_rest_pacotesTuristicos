package com.example.pacotesTuristicos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pacotesTuristicos.model.Pacote;
import com.example.pacotesTuristicos.repositories.PacoteRepository;

@Service
public class PacoteService {
	
	@Autowired
	private PacoteRepository repository;
	
	public List<Pacote> buscarTodos(){
		List<Pacote> pacotes = repository.findAll();
		return pacotes;
	}
	
	public Pacote buscarPorId(Integer id) {
		Optional<Pacote> pacote = repository.findById(id);
		return pacote.get();
	}
	
	public Pacote salvar(Pacote pacote) {
		return repository.save(pacote);
	}

	public void apagar(Integer id) {
		repository.deleteById(id);
	}
	
	public Pacote atualizar(Integer id, Pacote cidade) {
		Pacote obj = repository.getOne(id);
		updateData(obj, cidade);
		return repository.save(obj);
	}

	private void updateData(Pacote obj, Pacote pacote) {
		obj.setDataViagem(pacote.getDataViagem());
		obj.setDiasPermanencia(pacote.getDiasPermanencia());
		obj.setRefeicoesPorDia(pacote.getRefeicoesPorDia());
	}

	public List<Pacote> buscarPorNome(String nome) {
		List<Pacote> pacotes = repository.findByCidade_Nome(nome);
		return pacotes;
	}
	
	
}