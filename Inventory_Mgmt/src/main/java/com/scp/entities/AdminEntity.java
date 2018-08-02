package com.scp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="LoginInfo")
public class AdminEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_seq_gen")
	@SequenceGenerator(name="my_seq_gen", sequenceName="admin_seq",allocationSize=1)
	private int adminId;
	private String userName;
	private String password;
	public AdminEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminEntity(String userName, String password) {
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
	@Override
	public String toString() {
		return "AdminEntity [adminId=" + adminId + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
}
