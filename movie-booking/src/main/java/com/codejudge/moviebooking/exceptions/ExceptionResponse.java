package com.codejudge.moviebooking.exceptions;

public class ExceptionResponse {
	
	private String status;
	private String reason;
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public ExceptionResponse(String status,String reason) {
		super();
		this.status = status;
		this.reason = reason;
	}
	
	
	@Override
	public String toString() {
		return "ExceptionResponse [status=" + status + ", reason=" + reason + "]";
	}
	
	

}
