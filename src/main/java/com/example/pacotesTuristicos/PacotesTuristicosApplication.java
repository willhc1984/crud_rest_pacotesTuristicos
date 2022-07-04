package com.example.pacotesTuristicos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.pacotesTuristicos.model.Cidade;
import com.example.pacotesTuristicos.model.Hotel;
import com.example.pacotesTuristicos.repositories.CidadeRepository;
import com.example.pacotesTuristicos.repositories.HotelRepository;

@SpringBootApplication
public class PacotesTuristicosApplication implements CommandLineRunner {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private HotelRepository hotelRepository;

	public static void main(String[] args) {
		SpringApplication.run(PacotesTuristicosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cidade cidade1 = new Cidade(null, "Sorocaba", "SP", "www.sorocaba.com");
		Cidade cidade2 = new Cidade(null, "São Paulo", "SP", "www.sp.com");
		Cidade cidade3 = new Cidade(null, "Rio de Janeiro", "RJ", "www.rj.com");
		Cidade cidade4 = new Cidade(null, "Belo Horizonte", "MG", "www.bh.com");
		
		Hotel hotel1 = new Hotel(null, "Ibis Hotel", 325.00, cidade1);
		Hotel hotel2 = new Hotel(null, "All In Nacional", 478.00, cidade1);
		Hotel hotel3 = new Hotel(null, "All In Internacional", 126.00, cidade2);
		Hotel hotel4 = new Hotel(null, "Ibis Hotel", 325.00, cidade3);
		Hotel hotel5 = new Hotel(null, "Ibis Hotel", 325.00, cidade4);
		Hotel hotel6 = new Hotel(null, "All In Nacional", 325.00, cidade4);
		Hotel hotel7 = new Hotel(null, "Ibis Hotel", 325.00, cidade3);
		Hotel hotel8 = new Hotel(null, "All In Nacional", 325.00, cidade2);
		
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3, cidade4));
		hotelRepository.saveAll(Arrays.asList(hotel1, hotel2, hotel3, hotel4, hotel5, hotel6, hotel7, hotel8));
	}

}
