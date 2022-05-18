package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;

@RestController
public class BookController {
	private Map<String, Book> bookMap;
	

	@PostConstruct
	public void init() {
		bookMap = new HashMap<String, Book>();
		bookMap.put("1", new Book("1", "김호연", "불편한 편의점", 813));
		bookMap.put("2", new Book("2", "권정생", "강아지똥", 813));
		bookMap.put("3", new Book("3", "김성화, 권수진", "미래가 온다 매직 사이언스", 508));
	}
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") String id) {
		return bookMap.get(id);
	}
	
	@GetMapping("/book/all")
	public List<Book> getBookList() {
		return new ArrayList<Book>(bookMap.values());
	}
	
	@PutMapping("/book/{id}")
	public void putBook(@PathVariable("id") String id, @RequestParam("bookName") String bookName, @RequestParam("author") String Author, @RequestParam("genre") int genre) {
		Book book = new Book(id, bookName, Author, genre);
		bookMap.put(id, book);
	}
	
	@PostMapping("/book/{id}")
	public void postBook(@PathVariable("id") String id, @RequestParam("bookName") String bookName, @RequestParam("author") String Author, @RequestParam("genre") int genre) {
		Book book = bookMap.get(id);
		book.setBookName(bookName);
		book.setBookAuthor(Author);
		book.setBookGenre(genre);
	}
	
	@DeleteMapping("/book/{id}")
	public void deleteUserProfile(@PathVariable("id") String id) {
		bookMap.remove(id);
	}
}
