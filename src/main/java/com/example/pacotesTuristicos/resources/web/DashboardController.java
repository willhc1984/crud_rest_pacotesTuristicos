package com.example.pacotesTuristicos.resources.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pacotesTuristicos.model.Cidade;

@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController {
	
	@GetMapping
	public String index() {
		return "dashboard";
	}
	
	@GetMapping(value = "/usuarios/cadastro")
	public String cadusuarios() {
		return "cad-usuarios";
	}
	
	@GetMapping(value = "/pacotes/cadastro")
	public String cadpacotes() {
		return "cad-pacotes";
	}
	
	@GetMapping(value = "/hoteis/cadastro")
	public String cadhoteis() {
		return "cad-hoteis";
	}
	
	@GetMapping(value = "/cidades/cadastro")
	public String cadcidades(ModelMap model) {
		model.put("cidade", new Cidade());
		model.toString();
		return "cad-cidades";
	}
	
	@GetMapping(value = "/restaurantes/cadastro")
	public String cadrestaurantes() {
		return "cad-restaurantes";
	}

}
