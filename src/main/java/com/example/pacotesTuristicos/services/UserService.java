package com.example.pacotesTuristicos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pacotesTuristicos.model.User;
import com.example.pacotesTuristicos.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> buscarTodos(){
		List<User> users = userRepository.findAll();
		return users;
	}
	
	public User buscarPorId(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}
	
	public User salvar(User user) {
		return userRepository.save(user);
	}
	
	public void apagar(Long id) {
		userRepository.deleteById(id);
	}
	
	public User atualizar(Long id, User user) {
		User obj = userRepository.getOne(id);
		updateData(obj, user);
		return userRepository.save(obj);
	}

	private void updateData(User obj, User user) {
		obj.setUsername(user.getUsername());
		obj.setPassword(user.getPassword());
		obj.setEmail(user.getEmail());
	}
	
}
