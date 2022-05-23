package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.JsonForm.ResponseService;
import com.example.demo.JsonForm.Responses.ListResponse;
import com.example.demo.JsonForm.Responses.SingleResponse;
import com.example.demo.exception.exceptions.BookNotFoundException;
import com.example.demo.exception.exceptions.BookisEmptyException;
import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;

@RestController
public class BookController {
	
	private BookMapper mapper;
	
	public BookController(BookMapper mapper) {
		this.mapper = mapper;
	}

	//책 id로 정보 조회
	@GetMapping("/book/{id}")
	public SingleResponse<Book> getBook(@PathVariable("id") String id) {
		Book result = mapper.getBook(id);
		if(result != null) {
			return new ResponseService().getSingleResult(result);
		}
		else {
			throw new BookNotFoundException();
		}
	}
	
	//모든 책 조회
	@GetMapping("/book/all")
	public ListResponse<Book> getBookList() {
		List<Book> result = mapper.getBookList();
		if(!result.isEmpty()) {
			return new ResponseService().getLListResult(result);
		}
		else {
			throw new BookisEmptyException();
		}
	}
	
	//책 추가
	@PutMapping("/book/{id}")
	public void putBook(@PathVariable("id") String id, @RequestParam("bookName") String bookName, @RequestParam("author") String Author, @RequestParam("genre") int genre) {
		
		mapper.insertBook(id, bookName, Author, genre);
		
	}
	
	//책 수정
	@PostMapping("/book/{id}")
	public void postBook(@PathVariable("id") String id, @RequestParam("bookName") String bookName, @RequestParam("author") String Author, @RequestParam("genre") int genre) {
		mapper.updateBook(id, bookName, Author, genre);
	}
	
	//책 삭제
	@DeleteMapping("/book/{id}")
	public void deleteUserProfile(@PathVariable("id") String id) {
		mapper.deleteBook(id);
	}
	
}