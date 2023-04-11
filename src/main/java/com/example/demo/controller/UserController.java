package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/apis/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {

		this.userService = userService;
	}

	@ApiOperation(value = "add's a user and saves it to the database", notes = "saves to h2 database which will be wiped clean if you restart the API")
	@PostMapping(value = "/v1/newUser", consumes = "application/json", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = UserDto.class),
			@ApiResponse(code = 201, message = "Created", response = UserDto.class),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error")

	})
	public UserDto addUser(@RequestBody UserDto userDto) {
		return userService.addUser(userDto);
	}

	@ApiOperation(value = "get a user by id", notes = "saves to h2 database which will be wiped clean if you restart the API")
	@ApiParam(value = "the id that you insterted previously in the add endpoint", required = true)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = UserDto.class),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error")

	})
	@GetMapping(value = "/v1/{id}", produces = "application/json")
	public UserDto getUserById(@PathVariable int id) {
		return userService.findUserbyId(id);
	}

	@ApiOperation(value = "deletes a user by his id", notes = "saves to h2 database which will be wiped clean if you restart the API")
	@ApiParam(value = "id that was previously insterted", required = true)
	@DeleteMapping("/v1/deletion/{id}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = UserDto.class),
			@ApiResponse(code = 204, message = "No Content", response = UserDto.class),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public void deleteById(@PathVariable int id) {
		userService.deleteById(id);
	}

	@ApiOperation(value = "retrieves a list of all users", notes = "saves to h2 database which will be wiped clean if you restart the API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = UserDto.class),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error")

	})
	@GetMapping(value = "/v1/allUsers", produces = "application/json")
	public Page<UserDto> findAllUsers(Pageable page) {
		return userService.findAllUsers(page);
	}

}
