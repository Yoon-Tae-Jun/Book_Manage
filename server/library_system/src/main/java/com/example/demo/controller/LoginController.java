package com.example.demo.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.JsonForm.ResponseService;
import com.example.demo.JsonForm.Responses.BasicResponse;
import com.example.demo.JsonForm.Responses.ListResponse;
import com.example.demo.JsonForm.Responses.SingleResponse;
import com.example.demo.exception.exceptions.BookNotFoundException;
import com.example.demo.exception.exceptions.ParamValueException;
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
		System.out.println(userEmail+password);
		User result = mapper.Login(userEmail, password);
		if(result != null)
		{
			return new ResponseService().getSingleResult(result);			
		}
		else {
			throw new UserNotFoundException();
		}
	}
	@GetMapping("/user/borrowedBook/{id}")
	public ListResponse<Book> getBorrowedBook(@PathVariable("id") String id) {
		List<Book> result = mapper.getBorrowedBook(id);
		
		//데이터가 존재하는지 체크 
		if (!result.isEmpty()) {
			return new ResponseService().getLListResult(result);
		}
		else {
			throw new BookNotFoundException();
		}
		
	}
	
	@GetMapping("/user/reservedBook/{id}")
	public ListResponse<Book> getReservedBook(@PathVariable("id") String id) {
		List<Book> result = mapper.getReservedBook(id);
		

		return new ResponseService().getLListResult(result);
	
		
	}
	
	@GetMapping("/user/{id}")
	public SingleResponse<User> getUser(@PathVariable("id") String id){
		User result = mapper.getUser(id);
		if (result != null)
		{
			return new ResponseService().getSingleResult(result);
		}
		else{
			throw new UserNotFoundException();
		}
	}
	
	@PostMapping("user/search/{column}")
	public ListResponse<User> getUserOption(@PathVariable("column") String column_Type, @RequestParam("value") String value){
		int type = Integer.parseInt(column_Type);
		String column = "";
		//라디오박스 값 체크
		switch (type) {
		case 0:
			column = "userName";
			break;
		case 1:
			column = "userType";
			break;
		case 2:
			column = "userID";
			break;
		default:
			throw new ParamValueException();
		}
		

		List<User> result = mapper.getUserOption(column, value);
		//검색 후 값 검사
		if(!result.isEmpty()) {
			return new ResponseService().getLListResult(result);
		}
		else {
			throw new UserNotFoundException();
		}
	}
	
	//유저 삭제
	@DeleteMapping("user/{id}")
	public void deleteUser(@PathVariable("id") String id) {
		mapper.deleteUser(id);
	}
	
	//유저 추가
	@PostMapping("/user/put/{name}")
	public BasicResponse putUser(@PathVariable("name") String name, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("type") String type) {
		BasicResponse resultcode = new BasicResponse();
		if(mapper.emailCheck(email) == 0) {
			mapper.insertUser(email, password, name, type);
			resultcode.setMsg("추가 성공");
			resultcode.setStatusCode(200);
			return resultcode;				
		}
		else {
			resultcode.setMsg("이메일이 이미 존재합니다.");
			resultcode.setStatusCode(503);
			return resultcode;
		}
	}
	
	//유저 수정
	@PostMapping("/user/update/{userid}")
	public BasicResponse updateBook(@PathVariable("userid") String userId, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("name") String name) {

		BasicResponse resultcode = new BasicResponse();
		
		mapper.updateUser(email, password, name, userId);
		resultcode.setMsg("수정 성공");
		resultcode.setStatusCode(200);
		return resultcode;
	}
	
}
