package com.ouc.customerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ouc.customerportal.model.Person;

/**
 * Specifies methods used to obtain and modify person related information
 * which is stored in the database.
 */

public interface PersonRepository extends JpaRepository<Person, Long> {

}
