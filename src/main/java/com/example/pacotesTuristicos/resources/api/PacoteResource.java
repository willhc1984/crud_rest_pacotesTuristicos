package com.example.pacotesTuristicos.resources.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pacotesTuristicos.model.Pacote;
import com.example.pacotesTuristicos.services.PacoteService;

@RestController
@RequestMapping(value = "/api/pacotes")
@CrossOrigin(origins = "*")
public class PacoteResource {
	
	@Autowired
	private PacoteService service;
	
	@GetMapping
	public List<Pacote> buscarTodos(){
		return service.buscarTodos();
	}
	
	@GetMapping(value = "/{id}")
	public Pacote buscarPorId(@PathVariable Integer id) {
		return service.buscarPorId(id);
	}
	
	@PostMapping
	public ResponseEntity<Pacote> salvar(@RequestBody Pacote pacote){
		service.salvar(pacote);
		return ResponseEntity.ok().body(pacote);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Integer id){
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Pacote> atualizar(@PathVariable Integer id, @RequestBody Pacote pacote){
		pacote = service.atualizar(id, pacote);
		return ResponseEntity.ok().body(pacote);
	}
}
