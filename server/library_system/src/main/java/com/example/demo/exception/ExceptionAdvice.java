package com.example.demo.exception;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.JsonForm.ResponseService;
import com.example.demo.JsonForm.Responses.BasicResponse;
import com.example.demo.exception.exceptions.BookNotFoundException;
import com.example.demo.exception.exceptions.BookisEmptyException;
import com.example.demo.exception.exceptions.ParamValueException;
import com.example.demo.exception.exceptions.UserNotFoundException;

@RestControllerAdvice
public class ExceptionAdvice  {
	
	@ExceptionHandler(UserNotFoundException.class)
	protected BasicResponse userNotFoundException() {
		return new ResponseService().getFailResult(404,"해당 유저를 찾을 수 없음");
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	protected BasicResponse BookNotFoundException() {
		return new ResponseService().getFailResult(404, "해당 책을 찾을 수 없음");
	}
	
	@ExceptionHandler(BookisEmptyException.class)
	protected BasicResponse BookisEmptyException() {
		return new ResponseService().getFailResult(404, "책 테이블이 비어 있음");
	}
	
	@ExceptionHandler(ParamValueException.class)
	protected BasicResponse ParamValueException() {
		return new ResponseService().getFailResult(404, "파라미터 값이 잘못됨");
	}
}
