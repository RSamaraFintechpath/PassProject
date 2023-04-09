package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.UserDto;

public interface UserRepository extends JpaRepository<UserDto, Integer> {

	
}
