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
import com.example.pacotesTuristicos.model.Hotel;
import com.example.pacotesTuristicos.model.Pacote;
import com.example.pacotesTuristicos.model.Restaurante;
import com.example.pacotesTuristicos.services.CidadeService;
import com.example.pacotesTuristicos.services.HotelService;
import com.example.pacotesTuristicos.services.PacoteService;
import com.example.pacotesTuristicos.services.RestauranteService;

@Controller
@RequestMapping(value = "/dashboard/pacotes")
public class PacoteController {
	
	@Autowired
	private PacoteService pacoteService;
	
	@Autowired
	private RestauranteService restauranteService;
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private HotelService hotelService;
	
	@GetMapping(value = "/cadastrar")
	public String criar(ModelMap model) {
		model.put("pacote", new Pacote());
		model.put("restaurante", new Restaurante());
		model.put("cidade", new Cidade());
		model.put("hotel", new Hotel());
		List<Cidade> cidades = cidadeService.buscarTodos();
		List<Restaurante> restaurantes = restauranteService.buscarTodos();
		List<Hotel> hoteis = hotelService.buscarTodos();
		model.put("cidades", cidades);
		model.put("hoteis", hoteis);
		model.put("restaurantes", restaurantes);
		return "cad-pacotes";
	}
	
	@GetMapping
	public String listar(ModelMap model) {
		List<Pacote> pacotes = pacoteService.buscarTodos();
		model.put("pacotes", pacotes);
		return "listar-pacotes";
	}
	
	@GetMapping(value = "/{id}")
	public String listarPorId(@PathVariable Integer id, ModelMap model) {
		Pacote pacote = pacoteService.buscarPorId(id);
		List<Cidade> cidades = cidadeService.buscarTodos();
		List<Restaurante> restaurantes = restauranteService.buscarTodos();
		List<Hotel> hoteis = hotelService.buscarTodos();
		model.put("pacote", pacote);
		model.put("cidades", cidades);
		model.put("restaurantes", restaurantes);
		model.put("hoteis", hoteis);
		return "cad-pacotes";
	}
	
	@PostMapping
	public String salvar(@Valid @ModelAttribute Pacote pacote, BindingResult result,
			RedirectAttributes attr, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("pacote", pacote);
			model.addAttribute("cidades", cidadeService.buscarTodos());
			model.addAttribute("restaurantes", restauranteService.buscarTodos());
			model.addAttribute("hoteis", hotelService.buscarTodos());
			return "cad-pacotes";
		}
		
		pacoteService.salvar(pacote);
		attr.addFlashAttribute("success", "Pacote cadastrado!");
		return "redirect:/dashboard/pacotes/cadastrar";
	}
	
	@PostMapping(value = "/{id}")
	public String editar(@Valid @ModelAttribute Pacote pacote, BindingResult result,
			RedirectAttributes attr, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("pacote", pacote);
			model.addAttribute("cidades", cidadeService.buscarTodos());
			model.addAttribute("restaurantes", restauranteService.buscarTodos());
			model.addAttribute("hoteis", hotelService.buscarTodos());
			return "cad-pacotes";
		}
		
		pacoteService.salvar(pacote);
		attr.addFlashAttribute("success", "Pacote editado!");
		return "redirect:/dashboard/pacotes/cadastrar";
	}
	
	@GetMapping(value = "/excluir/{id}")
	public String excluir(@PathVariable Integer id, RedirectAttributes attr) {
		try {
			pacoteService.apagar(id);
			attr.addFlashAttribute("success", "Pacote excluido!");
			return "redirect:/dashboard/pacotes";	
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Erro de integridade de dados!");
		}
	
		return "redirect:/dashboard/pacotes";		
	}

}
