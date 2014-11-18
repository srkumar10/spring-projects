package com.ouc.customerportal.model;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class CustomerLogin {
	
	@NotEmpty
	@Size(min=4, max=20)
	@Column(name="username")
	private String userName;
	
	@NotEmpty
	@Size(min=4, max=8)	
	private String password;

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
		return "CustomerLogin [userName=" + userName + ", password=" + password
				+ "]";
	}

}
