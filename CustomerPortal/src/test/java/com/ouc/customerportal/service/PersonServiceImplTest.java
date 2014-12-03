package com.ouc.customerportal.service;

import static org.mockito.Mockito.mock;

import org.junit.Before;

import com.ouc.customerportal.repository.PersonRepository;


public class PersonServiceImplTest {

	private PersonServiceImpl personService;
	
	private PersonRepository personRepositoryMock;
	
	@Before
	public void setUp() {
		personService = new PersonServiceImpl();
		personRepositoryMock = mock(PersonRepository.class);
		personService.setPersonRepository(personRepositoryMock);
		
	}

}
