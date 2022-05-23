package com.example.demo.JsonForm.Responses;

public class SingleResponse<T> extends BasicResponse {
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
