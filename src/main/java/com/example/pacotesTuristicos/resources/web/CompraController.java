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

import com.example.pacotesTuristicos.model.Compra;
import com.example.pacotesTuristicos.services.CompraService;

@Controller
@RequestMapping(value = "/compras")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	
	@GetMapping
	public String listar(ModelMap model) {
		List<Compra> compras = compraService.buscarTodos();
		model.put("compras", compras);
		return "listar-compras";
	}
	
	@GetMapping(value = "/{id}")
	public String listarPorId(@PathVariable Long id, ModelMap model) {
		Compra compra = compraService.buscarPorId(id).get();
		model.put("compra", compra);
		return "pagamento";
	}
	
	
	 @PostMapping
	 public String salvar(@Valid @ModelAttribute Compra compra,
			 BindingResult result, RedirectAttributes attr, Model model) {
		 
			/*
			 * System.out.println(compra);
			 * 
			 * if(result.hasErrors()) { model.addAttribute("compra", compra); return
			 * "pagamento"; }
			 * 
			 * compraService.salvar(compra);
			 */
	 	attr.addFlashAttribute("success", "Compra realizada!"); 
	 	return "redirect:/compraRealizada"; 
	 }
	 
	 @PostMapping(value = "/{id}") 
	 public String editar(@Valid @ModelAttribute Compra compra, BindingResult result, 
			 RedirectAttributes attr, Model model) {
	 
		 System.out.println(compra);
		 
		 if(result.hasErrors()) { 
			 model.addAttribute("compra", compra); 
			 return "cad-compras"; 
		 }
		 
		 compraService.salvar(compra); 
		 attr.addFlashAttribute("success", "Compra editada!"); 
		 return "redirect:/dashboard/compras/cadastro"; 
	 
	 }
	 
	 /* @GetMapping(value = "/excluir/{id}") public String excluir(@PathVariable
	 * Integer id, RedirectAttributes attr) { try { compraService.apagar(id);
	 * attr.addFlashAttribute("success", "Compra excluida!"); return
	 * "redirect:/dashboard/compras"; } catch (Exception e) {
	 * attr.addFlashAttribute("fail", "Erro de integridade de dados!"); }
	 * 
	 * return "redirect:/dashboard/compras"; }
	 */

}
