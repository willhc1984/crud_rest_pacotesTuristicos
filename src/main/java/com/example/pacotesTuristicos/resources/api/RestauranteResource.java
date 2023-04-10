package com.example.pacotesTuristicos.resources.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pacotesTuristicos.model.Restaurante;
import com.example.pacotesTuristicos.services.RestauranteService;

@RestController
@RequestMapping(value = "/api/restaurantes")
@CrossOrigin(origins = "*")
public class RestauranteResource {
	
	@Autowired
	private RestauranteService service;
	
	@GetMapping
	public List<Restaurante> buscarTodos(){
		List<Restaurante> restaurantes = service.buscarTodos();
		return restaurantes;
	}
	
	@GetMapping(value = "/{id}")
	public Restaurante buscarPorId(@PathVariable Integer id) {
		Restaurante restaurante = service.buscarPorId(id);
		return restaurante;
	}
	
	@PostMapping
	public ResponseEntity<Restaurante> salvar(@RequestBody Restaurante restaurante){
		service.salvar(restaurante);
		return ResponseEntity.ok().body(restaurante);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Integer id){
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Restaurante> atualizar(@PathVariable Integer id, @RequestBody Restaurante restaurante){
		restaurante = service.atualizar(id, restaurante);
		return ResponseEntity.ok().body(restaurante);
	}

}
