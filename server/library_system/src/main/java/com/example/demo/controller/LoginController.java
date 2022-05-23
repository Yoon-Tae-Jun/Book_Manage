package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.JsonForm.ResponseService;
import com.example.demo.JsonForm.Responses.ListResponse;
import com.example.demo.JsonForm.Responses.SingleResponse;
import com.example.demo.exception.exceptions.UserNotFoundException;
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
	public SingleResponse<User> login(@RequestParam("userEmail") String userEmail, @RequestParam("password") String password) {
		User result = mapper.Login(userEmail, password);
		if(result != null)
		{
			return new ResponseService().getSingleResult(result);			
		}
		else {
			throw new UserNotFoundException();
		}
	}
	@GetMapping("/user/borrowedBook/{name}")
	public ListResponse<Book> getBorrowedBook(@PathVariable("name") String name) {
		List<Book> result = mapper.getBorrowedBook(name);
		
		//데이터가 존재하는지 체크 
		if (!result.isEmpty()) {
			return new ResponseService().getLListResult(result);
		}
		else {
			throw new UserNotFoundException();
		}
		
	}
	
}
