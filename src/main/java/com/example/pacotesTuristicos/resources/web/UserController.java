package com.example.pacotesTuristicos.resources.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.pacotesTuristicos.enums.RoleName;
import com.example.pacotesTuristicos.model.Role;
import com.example.pacotesTuristicos.model.User;
import com.example.pacotesTuristicos.repositories.RoleRepository;
import com.example.pacotesTuristicos.repositories.UserRepository;
import com.example.pacotesTuristicos.services.UserService;

@Controller
@RequestMapping(value = "/dashboard/usuarios")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/cadastrar")
	public String criar(ModelMap model) {
		model.put("user", new User());
		return "cad-usuarios";
	}
	
	@GetMapping
	public String listar(ModelMap model) {
		List<User> users = userService.buscarTodos();
		model.put("users", users);
		return "listar-usuarios";
	}
	
	@GetMapping(value = "/{id}")
	public String listarPorId(@PathVariable Long id, ModelMap model) {
		User user = userService.buscarPorId(id);
		model.put("user", user);
		return "cad-usuarios";
	}
	
	@PostMapping
	public String salvar(@Valid @ModelAttribute User user, BindingResult result,
			RedirectAttributes attr, Model model, @RequestParam(value = "confirm") String confirm) {
		
		if(!confirm.equals(user.getPassword())) {
			attr.addFlashAttribute("fail", "Senhas não correspondem!");
			return "redirect:/dashboard/usuarios/cadastrar";
		}
		
		System.out.println(user.getUsername());
		Optional<User> userOptional = userRepository.findByUsername(user.getUsername());
		
		if(userOptional.isPresent()) {
			attr.addFlashAttribute("fail", "Nome de usuario ou email já esta em uso!");
			return "redirect:/dashboard/usuarios/cadastrar";
		}

		if(result.hasErrors()) {
			model.addAttribute("user", user);
			return "cad-usuarios";
		}
		
		Optional<Role> role = roleRepository.findByRoleName(RoleName.ROLE_ADMIN);		
		user.getRoles().add(role.get());
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		
		userService.salvar(user);
		attr.addFlashAttribute("success", "Usuario cadastrado!");
		return "redirect:/dashboard/usuarios/cadastrar";
	}

	
	@PostMapping(value = "/{id}")
	public String editar(@Valid @ModelAttribute User user, BindingResult result,
			RedirectAttributes attr, Model model, @RequestParam(value = "confirm") String confirm) {
		
		
		if(!confirm.equals(user.getPassword())) {
			attr.addFlashAttribute("fail", "Senhas não correspondem!");
			return "redirect:/dashboard/usuarios/cadastrar";
		}
		
		if(result.hasErrors()) {
			model.addAttribute("user", user);
			return "cad-usuarios";
		}
		
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userService.salvar(user);
		System.out.println(user.toString());
		attr.addFlashAttribute("success", "Usuario editado!");
		return "redirect:/dashboard/users/cadastrar";
	}
	
	@GetMapping(value = "/excluir/{id}")
	public String excluir(@PathVariable Long id, RedirectAttributes attr) {
		try {
			userService.apagar(id);
			attr.addFlashAttribute("success", "Usuario excluido!");
			return "redirect:/dashboard/usuarios";	
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Erro de integridade de dados!");
		}
	
		return "redirect:/dashboard/usuarios";		
	}

}
