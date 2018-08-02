package com.scp.pojos;

public class AdminPojo {
	private int adminId;
	private String userName;
	private String password;
	public AdminPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminPojo( String userName, String password) {
		super();
		//this.adminId = adminId;
		this.userName = userName;
		this.password = password;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
