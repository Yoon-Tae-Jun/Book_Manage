package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Book;
import com.example.demo.model.User;

@RestController
public class LoginController {

	private UserMapper mapper;
	
	public LoginController(UserMapper mapper) {
		this.mapper = mapper;
	}
	@PostMapping("/login")
	public User login(@RequestParam("userEmail") String userEmail, @RequestParam("password") String password) {
		System.out.println(mapper.Login(userEmail, password).getUserEmail());
		return mapper.Login(userEmail, password);
	}
	@GetMapping("/user/borrowedBook/{name}")
	public Book getBorrowedBook(@PathVariable("name") String name) {
		return mapper.getBorrowedBook(name);
	}
	
}
