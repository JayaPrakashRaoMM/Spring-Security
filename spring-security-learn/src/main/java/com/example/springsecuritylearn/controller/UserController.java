package com.example.springsecuritylearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecuritylearn.model.User;
import com.example.springsecuritylearn.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private UserService userservice;
	
	@GetMapping("/all")
	public List<User> getAll()
	{
		return this.userservice.getAllUsers();
	}
	
	@GetMapping("/{username}")
	public User singleUser(@PathVariable("username") String username)
	{
		return this.userservice.getUser(username);
	}
	
	@PostMapping("/")
	public User add(@RequestBody User user)
	{
		return this.userservice.addUser(user);
	}
}
