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
import com.example.pacotesTuristicos.services.CidadeService;
import com.example.pacotesTuristicos.services.HotelService;

@Controller
@RequestMapping(value = "/dashboard/hoteis")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping(value = "/cadastrar")
	public String criar(ModelMap model) {
		model.put("hotel", new Hotel());
		model.put("cidade", new Cidade());
		List<Cidade> cidades = cidadeService.buscarTodos();
		model.put("cidades", cidades);
		return "cad-hoteis";
	}
	
	@GetMapping
	public String listar(ModelMap model) {
		List<Hotel> hoteis = hotelService.buscarTodos();
		model.put("hoteis", hoteis);
		return "listar-hoteis";
	}
	
	@GetMapping(value = "/{id}")
	public String listarPorId(@PathVariable Integer id, ModelMap model) {
		Hotel hotel = hotelService.buscarPorId(id);
		model.put("hotel", hotel);
		return "cad-hoteis";
	}
	
	@PostMapping
	public String salvar(@Valid @ModelAttribute Hotel hotel, BindingResult result,
			RedirectAttributes attr, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("hotel", hotel);
			return "cad-hoteis";
		}
		
		hotelService.salvar(hotel);
		attr.addFlashAttribute("success", "Hotel cadastrado!");
		return "redirect:/dashboard/hoteis/cadastro";
	}
	
	@PostMapping(value = "/{id}")
	public String editar(@Valid @ModelAttribute Hotel hotel, BindingResult result,
			RedirectAttributes attr, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("hotel", hotel);
			return "cad-hoteis";
		}
		
		hotelService.salvar(hotel);
		attr.addFlashAttribute("success", "Hotel editado!");
		return "redirect:/dashboard/hotels/cadastro";
	}
	
	@GetMapping(value = "/excluir/{id}")
	public String excluir(@PathVariable Integer id, RedirectAttributes attr) {
		try {
			hotelService.apagar(id);
			attr.addFlashAttribute("success", "Hotel excluido!");
			return "redirect:/dashboard/hoteis";	
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Erro de integridade de dados!");
		}
	
		return "redirect:/dashboard/hoteis";		
	}

}
