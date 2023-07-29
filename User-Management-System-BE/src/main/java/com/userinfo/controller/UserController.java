package com.userinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userinfo.model.User;
import com.userinfo.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public User newUser(@RequestBody User newUser) {
		return userService.saveUser(newUser);
		
	}
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getById(id);
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User newUser, @PathVariable Long id) {
		return userService.updateUserById(newUser, id);
				
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUserById(id);
	}
	

}
