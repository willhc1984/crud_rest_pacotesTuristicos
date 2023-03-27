package com.example.pacotesTuristicos.resources.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/pacotes")
	public String pacotes() {
		return "redirect:#busca";
	}
	
	@GetMapping(value = "/promocoes")
	public String promocoes() {
		return "redirect:#promocoes";
	}
	
	@GetMapping(value = "/contato")
	public String contato() {
		return "redirect:#contato";
	}
	
	@GetMapping(value = "/sobrenos")
	public String sobrenos() {
		return "sobrenos";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value = "/register")
	public String register() {
		return "register";
	}
	
	@GetMapping(value = "/acessoNegado")
	public String acessoNegado() {
		return "acessoNegado";
	}

}
