package com.example.pacotesTuristicos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pacotesTuristicos.model.Hotel;
import com.example.pacotesTuristicos.repositories.HotelRepository;


@Service
public class HotelService {
	
	@Autowired
	private HotelRepository repository;
	
	public List<Hotel> buscarTodos(){
		List<Hotel> hoteis = repository.findAll();
		return hoteis;
	}
	
	public Hotel buscarPorId(Integer id) {
		Optional<Hotel> hotel = repository.findById(id);
		return hotel.get();
	}
	
	public Hotel salvar(Hotel hotel) {
		return repository.save(hotel);
	}
	
	public void apagar(Integer id) {
		repository.deleteById(id);
	}
	
	public Hotel atualizar(Integer id, Hotel hotel) {
		Hotel obj = repository.getOne(id);
		updateData(obj, hotel);
		return repository.save(obj);
		
	}

	private void updateData(Hotel obj, Hotel hotel) {
		obj.setNome(hotel.getNome());
		obj.setValorDiaria(hotel.getValorDiaria());
	}

}
