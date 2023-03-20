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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.pacotesTuristicos.model.Cidade;
import com.example.pacotesTuristicos.model.Restaurante;
import com.example.pacotesTuristicos.services.CidadeService;
import com.example.pacotesTuristicos.services.RestauranteService;

@Controller
@RequestMapping(value = "/dashboard/restaurantes")
public class RestauranteController {
	
	@Autowired
	private RestauranteService restauranteService;
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping(value = "/cadastrar")
	public String criar(ModelMap model) {
		model.put("restaurante", new Restaurante());
		model.put("cidade", new Cidade());
		List<Cidade> cidades = cidadeService.buscarTodos();
		model.put("cidades", cidades);
		return "cad-restaurantes";
	}
	
	@GetMapping
	public String listar(ModelMap model) {
		List<Restaurante> restaurantes = restauranteService.buscarTodos();
		model.put("restaurantes", restaurantes);
		return "listar-restaurantes";
	}
	
	@GetMapping(value = "/{id}")
	public String listarPorId(@PathVariable Integer id, ModelMap model) {
		Restaurante restaurante = restauranteService.buscarPorId(id);
		model.put("restaurante", restaurante);
		List<Cidade> cidades = cidadeService.buscarTodos();
		model.put("cidades", cidades);
		return "cad-restaurantes";
	}
	
	@PostMapping
	public String salvar(@Valid @ModelAttribute Restaurante restaurante, BindingResult result,
			RedirectAttributes attr, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("restaurante", restaurante);
			model.addAttribute("cidades", cidadeService.buscarTodos());
			return "cad-restaurantes";
		}
		
		restauranteService.salvar(restaurante);
		attr.addFlashAttribute("success", "Restaurante cadastrado!");
		return "redirect:/dashboard/restaurantes/cadastrar";
	}
	
	@PostMapping(value = "/{id}")
	public String editar(@Valid @ModelAttribute Restaurante restaurante, BindingResult result,
			RedirectAttributes attr, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("restaurante", restaurante);
			model.addAttribute("cidades", cidadeService.buscarTodos());
			return "cad-restaurantes";
		}
		
		restauranteService.salvar(restaurante);
		attr.addFlashAttribute("success", "Restaurante editado!");
		return "redirect:/dashboard/restaurantes/cadastrar";
	}
	
	@GetMapping(value = "/excluir/{id}")
	public String excluir(@PathVariable Integer id, RedirectAttributes attr) {
		try {
			restauranteService.apagar(id);
			attr.addFlashAttribute("success", "Restaurante excluido!");
			return "redirect:/dashboard/restaurantes";	
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Erro de integridade de dados!");
		}
	
		return "redirect:/dashboard/restaurantes";		
	}

}
