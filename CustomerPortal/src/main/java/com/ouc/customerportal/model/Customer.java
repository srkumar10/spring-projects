package com.ouc.customerportal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private long id;
	
	@NotEmpty
	@Size(min=4, max=20)
	@Column(name="username")
	private String userName;
	
	@NotEmpty
	@Column(name="firstname")	
	private String firstName;
	
	@NotEmpty
	@Column(name="lastname")
	private String lastName;
	
	@NotEmpty
	@Size(min=4, max=8)
	private String password;	
	
	@NotNull
	@Past
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name="dateofbirth")
	private Date dateOfBirth;
	
	@NotNull
	@Email
	private String email;
	
	@NotEmpty
	@Size(max=10)
	private String phone;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", userName=" + userName + ", firstName="
				+ firstName + ", lastName=" + lastName + ", password="
				+ password + ", dateOfBirth=" + dateOfBirth + ", email="
				+ email + ", phone=" + phone + "]";
	}

}
