package com.ouc.customerportal.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * A DTO object which is used as a form object
 * in create person and edit person forms.
 */

public class PersonDTO {
	
	private Long id;
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	public PersonDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
