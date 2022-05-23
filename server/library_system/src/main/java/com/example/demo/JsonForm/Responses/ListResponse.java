package com.example.demo.JsonForm.Responses;

import java.util.List;

public class ListResponse<T> extends BasicResponse {
	private List<T> data;

	public List<T> getdata() {
		return data;
	}

	public void setdata(List<T> data) {
		this.data = data;
	}
}
