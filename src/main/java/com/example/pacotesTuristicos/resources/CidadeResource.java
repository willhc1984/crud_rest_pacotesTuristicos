package com.example.pacotesTuristicos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pacotesTuristicos.model.Cidade;
import com.example.pacotesTuristicos.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {
	
	@Autowired
	private CidadeService service;
	
	@GetMapping
	public List<Cidade> buscarTodos(){
		List<Cidade> cidades = service.buscarTodos();
		return cidades;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cidade> buscarPorId(@PathVariable Integer id) {
		Cidade cidade = service.buscarPorId(id);
		return ResponseEntity.ok().body(cidade);
	}
	
	@PostMapping
	public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade){
		cidade = service.salvar(cidade);
		return ResponseEntity.ok().body(cidade);
	}

}
