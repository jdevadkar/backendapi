package com.xpx.entity;

public class ApiToken {
	
	
	
	private String access_token ;
	private String refresh_token;
	private String sessionId;
	
	
	public ApiToken() {
		super();
	}
	
	
	
	public ApiToken(String access_token, String refresh_token, String sessionId) {
		super();
		this.access_token = access_token;
		this.refresh_token = refresh_token;
		this.sessionId = sessionId;
	}



	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	
	
	
	
	

}
