package com.xyinc.poi.api.responses;

import java.util.List;

public class Response<T> {
	private T payload;
	private List<String> errors;
	
	public Response(T payload) {
		this.payload = payload;
	}
	
	public Response(List<String> errors) {
		this.errors = errors;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
