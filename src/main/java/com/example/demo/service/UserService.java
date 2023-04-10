package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	public Page<UserDto> findAllUsers(Pageable page) {
		return userRepository.findAll(page);
	}
	

	

	
}

