package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.JsonForm.ResponseService;
import com.example.demo.JsonForm.Responses.BasicResponse;
import com.example.demo.JsonForm.Responses.ListResponse;
import com.example.demo.JsonForm.Responses.SingleResponse;
import com.example.demo.exception.exceptions.BookNotFoundException;
import com.example.demo.exception.exceptions.BookisEmptyException;
import com.example.demo.exception.exceptions.ParamValueException;
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
	
	@PostMapping("book/search/{column}")
	public ListResponse<Book> getBookOption(@PathVariable("column") String column_Type, @RequestParam("value") String value){
		int type = Integer.parseInt(column_Type);
		String column = "";
		//라디오박스 값 체크
		switch (type) {
		case 0:
			column = "BookName";
			break;
		case 1:
			column = "BookAuthor";
			break;
		case 2:
			column = "BookGenre";
			break;
		case 3:
			column = "PublicationYear";
			break;
		case 4:
			column = "BookID";
			break;
		default:
			throw new ParamValueException();
		}
		
		System.out.println(column + "  "+ value);
		List<Book> result = mapper.getBookOption(column, value);
		System.out.println(result.isEmpty());
		
		//검색 후 값 검사
		if(!result.isEmpty()) {
			return new ResponseService().getLListResult(result);
		}
		else {
			throw new BookNotFoundException();
		}
	}
	
	//책 추가
	@PutMapping("/book/{id}")
	public void putBook(@PathVariable("id") String id, @RequestParam("bookName") String bookName, @RequestParam("author") String Author, @RequestParam("genre") int genre) {
		
		mapper.insertBook(id, bookName, Author, genre);
		
	}
	
	//책 대출
	@PostMapping("/book/borrowed/{bookid}")
	public BasicResponse postBook(@PathVariable("bookid") String bookId, @RequestParam("userID") String userID) {
		Book result = mapper.getBook(bookId);
		BasicResponse resultcode = new BasicResponse();
		if(result.isBorrowed()) {
			Calendar cal = Calendar.getInstance();
			Date now = new Date();
			cal.setTime(now);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String now_dt = format.format(now);
			cal.add(Calendar.DATE, 7);
			String return_dt = format.format(cal.getTime()); 
			mapper.borrowedBook(userID,now_dt, return_dt, bookId);
			
			resultcode.setMsg("대출 성공");
			resultcode.setStatusCode(200);
			return resultcode;
		}
		else {
			resultcode.setMsg("대출 실패");
			resultcode.setStatusCode(500);
			return resultcode;
		}
		
	}
	
	//책 삭제
	@DeleteMapping("/book/{id}")
	public void deleteUserProfile(@PathVariable("id") String id) {
		mapper.deleteBook(id);
	}
	
}