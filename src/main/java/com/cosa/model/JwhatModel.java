package com.cosa.model;

import java.io.Serializable;

public class JwhatModel implements Serializable{
	private Integer tokenNo;
	private String tokenUser;
	private String token;
	public JwhatModel(Integer tokenNo, String tokenUser, String token) {
		super();
		this.tokenNo = tokenNo;
		this.tokenUser = tokenUser;
		this.token = token;
	}
	public JwhatModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getTokenNo() {
		return tokenNo;
	}
	public void setTokenNo(Integer tokenNo) {
		this.tokenNo = tokenNo;
	}
	public String getTokenUser() {
		return tokenUser;
	}
	public void setTokenUser(String tokenUser) {
		this.tokenUser = tokenUser;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "JwhatModel [tokenNo=" + tokenNo + ", tokenUser=" + tokenUser + ", token=" + token + "]";
	}
	
}
