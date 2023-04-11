package com.example.demo;

import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dto.UserDto;
import com.example.demo.repo.UserRepository;

@SpringBootApplication

public class PassProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository) {
		return args -> IntStream.rangeClosed(1, 30).forEach(i -> {
			UserDto user = new UserDto();
			user.setFirstName("user" + i);
			user.setLastName("user");
			user.setAge(i + 20);
			user.setPhoneNumber("0796326078");
			user.setEmail("user"+i+"@mail.com");
			userRepository.save(user);

		});
	}

}
