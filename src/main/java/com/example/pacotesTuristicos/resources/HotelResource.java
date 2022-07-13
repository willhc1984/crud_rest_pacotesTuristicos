package com.example.pacotesTuristicos.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(hotel.getId()).toUri();
		return ResponseEntity.created(uri).body(hotel);
	}
	
}
