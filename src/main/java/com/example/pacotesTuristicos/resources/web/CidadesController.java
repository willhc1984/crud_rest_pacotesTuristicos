package com.example.pacotesTuristicos.resources.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pacotesTuristicos.model.Cidade;
import com.example.pacotesTuristicos.services.CidadeService;

@Controller
@RequestMapping(value = "/dashboard/cidades")
public class CidadesController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping
	public String criar(ModelMap model) {
		model.put("cidade", new Cidade());
		return "cad-cidades";
	}
	
	@PostMapping
	public String salvar(@ModelAttribute Cidade cidade) {
		System.out.println(cidade);
		cidadeService.salvar(cidade);
		return "redirect:/dashboard/cidades/cadastro";
	}

}
