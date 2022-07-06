package com.example.pacotesTuristicos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pacotesTuristicos.model.Hotel;
import com.example.pacotesTuristicos.services.HotelService;

@RestController
@RequestMapping(value = "/hoteis")
public class HotelResource {
	
	@Autowired
	private HotelService service;
	
	@GetMapping
	public List<Hotel> buscarTodos(){
		List<Hotel> hoteis = service.buscarTodos();
		return hoteis;
	}
	
	@GetMapping(value = "/{id}")
	public Hotel buscarPorId(@PathVariable Integer id) {
		Hotel hotel = service.buscarPorId(id);
		return hotel;
	}
	
	@PostMapping
	public ResponseEntity<Hotel> salvar(@RequestBody Hotel hotel){
		service.salvar(hotel);
		return ResponseEntity.ok().body(hotel);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Integer id){
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Hotel> atualizar(@PathVariable Integer id, @RequestBody Hotel hotel){
		hotel = service.atualizar(id, hotel);
		return ResponseEntity.ok().body(hotel);
	}
	
	
}
