package com.example.pacotesTuristicos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.pacotesTuristicos.model.Restaurante;
import com.example.pacotesTuristicos.repositories.RestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository repository;
	
	public List<Restaurante> buscarTodos(){
		List<Restaurante> restaurantes = repository.findAll();
		return restaurantes;
	}
	
	public Restaurante buscarPorId(@PathVariable Integer id) {
		Optional<Restaurante> restaurante = repository.findById(id);
		return restaurante.get();
	}
	
	public Restaurante salvar(Restaurante restaurante) {
		return repository.save(restaurante);
	}
	
	public void apagar(Integer id) {
		repository.deleteById(id);
	}
	
	public Restaurante atualizar(Integer id, Restaurante restaurante) {
		Restaurante obj = repository.getOne(id);
		updateData(obj, restaurante);
		return repository.save(obj);		
	}

	private void updateData(Restaurante obj, Restaurante restaurante) {
		obj.setNome(restaurante.getNome());
		obj.setValorRefeicao(restaurante.getValorRefeicao());
	}

}
