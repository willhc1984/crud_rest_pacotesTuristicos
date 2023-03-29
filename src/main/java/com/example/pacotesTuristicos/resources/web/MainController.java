package com.example.pacotesTuristicos.resources.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.pacotesTuristicos.enums.RoleName;
import com.example.pacotesTuristicos.model.Role;
import com.example.pacotesTuristicos.model.User;
import com.example.pacotesTuristicos.repositories.RoleRepository;
import com.example.pacotesTuristicos.repositories.UserRepository;
import com.example.pacotesTuristicos.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
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
	public String register(ModelMap model) {
		model.put("user", new User());
		return "register";
	}
	
	@PostMapping(value = "/register")
	public String registrar(@Valid @ModelAttribute User user, BindingResult result,
			RedirectAttributes attr, Model model, @RequestParam(value = "confirm") String confirm) {
		
		if(!confirm.equals(user.getPassword())) {
			attr.addFlashAttribute("fail", "Senhas não correspondem!");
			return "redirect:/register";
		}
		
		Optional<User> userOptional = userRepository.findByUsername(user.getUsername());
		
		if(userOptional.isPresent()) {
			attr.addFlashAttribute("fail", "Nome de usuario ou email já esta em uso!");
			return "redirect:/register";
		}

		if(result.hasErrors()) {
			model.addAttribute("user", user);
			return "register";
		}
		
		Optional<Role> role = roleRepository.findByRoleName(RoleName.ROLE_USER);		
		user.getRoles().add(role.get());
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		
		userService.salvar(user);
		attr.addFlashAttribute("success", "Usuario registrado!");
		return "redirect:/login";
	}
	
	@GetMapping(value = "/acessoNegado")
	public String acessoNegado() {
		return "acessoNegado";
	}

}
