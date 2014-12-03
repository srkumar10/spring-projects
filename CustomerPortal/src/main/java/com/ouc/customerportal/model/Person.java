package com.ouc.customerportal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * An entity class which contains the information of a single person.
 */

@Entity
@Table(name="persons")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="creation_time", nullable=false)
	private Date creationTime;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(name="modification_time", nullable=false)
	private Date modificationtime;
	
	@Version
	private long version=0;
	
	

	public Date getCreationTime() {
		return creationTime;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getModificationtime() {
		return modificationtime;
	}	
	
	public Long getId() {
		return id;
	}

	/** Gets the full name of the person **/
	public String getName() {
		StringBuilder name = new StringBuilder();
		name.append(firstName);
		name.append(lastName);
		return name.toString();
	}
	
	public void update(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
	
	@PreUpdate
	public void preUpdate() {
		modificationtime = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		Date now = new Date();
		creationTime = now;
		modificationtime = now;				
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
	/**
     * Gets a builder which is used to create Person objects.
     * @param firstName The first name of the created user.
     * @param lastName  The last name of the created user.
     * @return  A new Builder instance.
     */
    public static Builder getBuilder(String firstName, String lastName) {
        return new Builder(firstName, lastName);
    }
    
	
	/**
     * A Builder class used to create new Person objects.
     */
    public static class Builder {
        Person built;
 
        /**
         * Creates a new Builder instance.
         * @param firstName The first name of the created Person object.
         * @param lastName  The last name of the created Person object.
         */
        Builder(String firstName, String lastName) {
            built = new Person();
            built.firstName = firstName;
            built.lastName = lastName;
        }
 
        /**
         * Builds the new Person object.
         * @return  The created Person object.
         */
        public Person build() {
            return built;
        }
    }
    
	
    /**
     * This setter method should only be used by unit tests.
     * @param id
     */
    protected void setId(Long id) {
        this.id = id;
    }

}
