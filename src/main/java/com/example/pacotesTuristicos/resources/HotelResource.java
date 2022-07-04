package com.example.pacotesTuristicos.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
}
