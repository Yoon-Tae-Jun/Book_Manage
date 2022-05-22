package com.example.demo.JsonForm;


public class BasicResponse<T> {
	
	private int statusCode;
	private String responseMessage;
	private T data;
	
	public BasicResponse() {
		this.statusCode = 400;
		this.responseMessage = null;
		this.data = null;
	}

	public BasicResponse(int statusCoude, String responseMessage) {
		this.statusCode = statusCoude;
		this.responseMessage = responseMessage;
	}
	public BasicResponse(int statusCoude, String responseMessage, T data) {
		this.statusCode = statusCoude;
		this.responseMessage = responseMessage;
		this.data = data;
	}
	
}
