package com.example.pacotesTuristicos;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.pacotesTuristicos.model.Cidade;
import com.example.pacotesTuristicos.model.Hotel;
import com.example.pacotesTuristicos.model.Pacote;
import com.example.pacotesTuristicos.model.Restaurante;
import com.example.pacotesTuristicos.repositories.CidadeRepository;
import com.example.pacotesTuristicos.repositories.HotelRepository;
import com.example.pacotesTuristicos.repositories.PacoteRepository;
import com.example.pacotesTuristicos.repositories.RestauranteRepository;

@SpringBootApplication
public class PacotesTuristicosApplication implements CommandLineRunner {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private RestauranteRepository restauranteRepository;
	@Autowired
	private PacoteRepository pacoteRepository;

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
		
		Restaurante r1 = new Restaurante(null, "Du chief", 564.00, cidade1);
		Restaurante r2 = new Restaurante(null, "Du chief", 123.00, cidade2);
		Restaurante r3 = new Restaurante(null, "Tempero Manero", 643.00, cidade3);
		Restaurante r4 = new Restaurante(null, "Tempero Manero", 54.00, cidade4);
		Restaurante r5 = new Restaurante(null, "Gaucho", 213.00, cidade4);
		Restaurante r6 = new Restaurante(null, "Gaucho", 324.00, cidade2);
		Restaurante r7 = new Restaurante(null, "Japa Grills", 234.00, cidade1);
		
		Pacote p1 = new Pacote(null, new Date(), 4, 8, cidade1, r1, hotel1);
		Pacote p2 = new Pacote(null, new Date(), 4, 8, cidade2, r2, hotel2);
		Pacote p3 = new Pacote(null, new Date(), 4, 8, cidade3, r3, hotel3);
		Pacote p4 = new Pacote(null, new Date(), 4, 8, cidade4, r4, hotel4);
		
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3, cidade4));
		hotelRepository.saveAll(Arrays.asList(hotel1, hotel2, hotel3, hotel4, hotel5, hotel6, hotel7, hotel8));
		restauranteRepository.saveAll(Arrays.asList(r1, r2, r3, r4, r5, r6, r7));
		pacoteRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
	}

}
