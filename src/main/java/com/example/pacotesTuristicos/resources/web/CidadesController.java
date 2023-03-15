package com.example.pacotesTuristicos.resources.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.pacotesTuristicos.model.Cidade;
import com.example.pacotesTuristicos.services.CidadeService;

@Controller
@RequestMapping(value = "/dashboard/cidades")
public class CidadesController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping(value = "/cadastrar")
	public String criar(ModelMap model) {
		model.put("cidade", new Cidade());
		return "cad-cidades";
	}
	
	@GetMapping
	public String listar(ModelMap model) {
		List<Cidade> cidades = cidadeService.buscarTodos();
		model.put("cidades", cidades);
		return "listar-cidades";
	}
	
	@PostMapping
	public String salvar(@Valid @ModelAttribute Cidade cidade, BindingResult result,
			RedirectAttributes attr, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("cidade", cidade);
			return "cad-cidades";
		}
		
		cidadeService.salvar(cidade);
		attr.addFlashAttribute("success", "Cidade cadastrada!");
		return "redirect:/dashboard/cidades/cadastro";
	}

}
