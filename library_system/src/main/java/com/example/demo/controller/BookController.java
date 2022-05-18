package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;

@RestController
public class BookController {
	
	private BookMapper mapper;
	
	public BookController(BookMapper mapper) {
		this.mapper = mapper;
	}

	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") String id) {
		return mapper.getBook(id);
	}
	
	@GetMapping("/book/all")
	public List<Book> getBookList() {
		return mapper.getBookList();
	}
	
	@PutMapping("/book/{id}")
	public void putBook(@PathVariable("id") String id, @RequestParam("bookName") String bookName, @RequestParam("author") String Author, @RequestParam("genre") int genre) {
		mapper.insertBook(id, bookName, Author, genre);
		
	}
	
	@PostMapping("/book/{id}")
	public void postBook(@PathVariable("id") String id, @RequestParam("bookName") String bookName, @RequestParam("author") String Author, @RequestParam("genre") int genre) {
		mapper.updateBook(id, bookName, Author, genre);
	}
	
	@DeleteMapping("/book/{id}")
	public void deleteUserProfile(@PathVariable("id") String id) {
		mapper.deleteBook(id);
	}
}