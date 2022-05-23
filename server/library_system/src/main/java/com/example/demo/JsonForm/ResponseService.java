package com.example.demo.JsonForm;

import java.util.List;

import com.example.demo.JsonForm.Responses.BasicResponse;
import com.example.demo.JsonForm.Responses.ListResponse;
import com.example.demo.JsonForm.Responses.SingleResponse;

public class ResponseService {
	
	public <T> SingleResponse<T> getSingleResult(T data){
		SingleResponse<T> result = new SingleResponse<>();
		result.setData(data);
		setSuccessResult(result);
		return result;
	}
	
	public <T> ListResponse<T> getLListResult(List<T> data){
		ListResponse<T> result = new ListResponse<>();
		result.setdata(data);
		setSuccessResult(result);
		return result;
	}
	
	public BasicResponse getFailResult (int code, String msg){
		BasicResponse result = new BasicResponse();
		result.setStatusCode(code);
		result.setMsg(msg);
		return result;
	}
	public <T> ListResponse<T> getListFailResult(int code, String msg, List<T> data) {
		ListResponse<T> result = new ListResponse<>();
		result.setStatusCode(code);
		result.setMsg(msg);
		result.setdata(data);
		return result;
		
	}
	private void setSuccessResult(BasicResponse result) {
		result.setStatusCode(200);
		result.setMsg("OK");
	}
}
