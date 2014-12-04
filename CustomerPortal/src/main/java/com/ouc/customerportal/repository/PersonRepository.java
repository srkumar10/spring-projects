package com.ouc.customerportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ouc.customerportal.model.Person;

/**
 * Specifies methods used to obtain and modify person related information
 * which is stored in the database.
 */

public interface PersonRepository extends JpaRepository<Person, Long> {
	
	/**
	 * 1-Option => Query Creation using Method Name
     * Finds persons by using the last name as a search criteria.
     * @param lastName  
     * @return  A list of persons which last name is an exact match with the given last name.
     *          If no persons is found, this method returns an empty list.
     */
    public List<Person> findByLastName(String lastName);
    
    
    
    /**
     * 2-Option => Query creation using Named Queries
     * Finds person by using the last name as a search criteria.
     * @param lastName
     * @return  A list of persons whose last name is an exact match with the given last name.
     *          If no persons is found, this method returns null.
     */
    public List<Person> findByName(String lastName);
    
    
    /**
     * 3-Option => Query creation using @Query Annotation
     * Finds a person by using the last name as a search criteria.
     * @param lastName
     * @return  A list of persons whose last name is an exact match with the given last name.
     *          If no persons is found, this method returns an empty list.
     */
    @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
    public List<Person> find(@Param("lastName") String lastName);

}
