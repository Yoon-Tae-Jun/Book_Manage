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
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Book;
import com.example.demo.model.User;

@RestController
public class BookController {
	
	private BookMapper mapper;
	private UserMapper userMapper;
	
	public BookController(BookMapper mapper, UserMapper userMapper) {
		this.userMapper = userMapper;
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
	
	// 책 검색
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
	public BasicResponse borrowedBook(@PathVariable("bookid") String bookId, @RequestParam("userID") String userID) {
		Book result = mapper.getBook(bookId);
		User user = userMapper.getUser(userID);
		BasicResponse resultcode = new BasicResponse();
		if((result.isBorrowed() && result.isReserved() )&& user.getOverdueDay() == 0) {
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
		}
		else if(user.getOverdueDay() != 0) {
			resultcode.setMsg("대출 실패");
			resultcode.setStatusCode(500);
		}
		else if (!result.isReserved()) {
			if(result.getReservedUser().equals(userID)) {
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
			}
			else {
				resultcode.setMsg("대출 실패");
				resultcode.setStatusCode(500);
			}
		}
		else {
			resultcode.setMsg("대출 실패");
			resultcode.setStatusCode(500);
		}
		return resultcode;
	}
	
	//책 예약
	@PostMapping("/book/reserved/{bookid}")
	public BasicResponse reservedBook(@PathVariable("bookid") String bookId, @RequestParam("userID") String userID) {
		Book result = mapper.getBook(bookId);
		User user = userMapper.getUser(userID);
		BasicResponse resultcode = new BasicResponse();
		if(!result.isReserved()) {
			resultcode.setMsg("예약 실패");
			resultcode.setStatusCode(500);
		}
		else if(user.getOverdueDay() != 0) {
			resultcode.setMsg("예약 실패");
			resultcode.setStatusCode(500);
		}
		else if (result.getBorrowedUser() != null) {
			if( result.getBorrowedUser().equals(userID)){
				resultcode.setMsg("이미 대출중");
				resultcode.setStatusCode(500);
			}
			else {
				mapper.reservedBook(userID, bookId);
				resultcode.setMsg("예약 성공");
				resultcode.setStatusCode(200);
			}
		}
		else {
			mapper.reservedBook(userID, bookId);
			resultcode.setMsg("예약 성공");
			resultcode.setStatusCode(200);
			
		}
		return resultcode;
	}
	
	//책 예약 취소
	@PostMapping("/book/reserved/cancel/{bookid}")
	public  BasicResponse cancelReservedBook(@PathVariable("bookid") String bookId, @RequestParam("userID") String userID) {
		Book result = mapper.getBook(bookId);
		BasicResponse resultcode = new BasicResponse();
		if (!result.isReserved()) {
			if(result.getReservedUser().equals(userID)) {
				mapper.cancelReservedBook(bookId);
				resultcode.setMsg("취소 성공");
				resultcode.setStatusCode(200);
			}
			else {
				resultcode.setMsg("예약한 사용자가 아님");
				resultcode.setStatusCode(500);
			}
		}
		else {
			resultcode.setMsg("예약 중이지 않음");
			resultcode.setStatusCode(500);
		}
		return resultcode;
	}
	
	//책 반납
	@PostMapping("/book/return/{bookid}")
	public  BasicResponse returnBook(@PathVariable("bookid") String bookId, @RequestParam("userID") String userID, @RequestParam("userID") String day) {
		Book result = mapper.getBook(bookId);
		BasicResponse resultcode = new BasicResponse();
		if(!result.isBorrowed()) {
			if(result.getBorrowedUser().equals(userID)) {
				userMapper.updateOverdue(day, userID);
				mapper.returnBook(bookId);
				resultcode.setMsg("반납 성공");
				resultcode.setStatusCode(200);
			}
			else {
				resultcode.setMsg("대출한 사용자가 아님");
				resultcode.setStatusCode(500);
			}
		}
		else {
			resultcode.setMsg("대출 중이지 않음");
			resultcode.setStatusCode(500);
		}
		return resultcode;
	}
	//책 삭제
	@DeleteMapping("/book/{id}")
	public void deleteUserProfile(@PathVariable("id") String id) {
		mapper.deleteBook(id);
	}
	
}