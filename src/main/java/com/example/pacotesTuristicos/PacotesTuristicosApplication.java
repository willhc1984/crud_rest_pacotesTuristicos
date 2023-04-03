package com.example.pacotesTuristicos;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
		
		Restaurante r2 = new Restaurante(null, "Du chief", 123.00, cidade2);
		Restaurante r3 = new Restaurante(null, "Tempero Manero", 643.00, cidade3);
		Restaurante r6 = new Restaurante(null, "Gaucho", 324.00, cidade2);
		Restaurante r7 = new Restaurante(null, "Japa Grills", 234.00, cidade1);
		
		
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3, cidade4));
		hotelRepository.saveAll(Arrays.asList(hotel1, hotel2, hotel3));
		restauranteRepository.saveAll(Arrays.asList(r2, r3, r6, r7));
	
		
	}

}
