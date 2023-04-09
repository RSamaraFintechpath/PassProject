package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDto addUser(UserDto user) {
		userRepository.save(user);
		return user;
	}

	public UserDto findUserbyId(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public void deleteById(int id) {
		userRepository.deleteById(id);
	}

	public List<UserDto> findAllUsers() {
		return userRepository.findAll();
	}
	

	

	
}

