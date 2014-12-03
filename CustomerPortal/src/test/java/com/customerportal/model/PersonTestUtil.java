package com.customerportal.model;

import com.ouc.customerportal.dto.PersonDTO;
import com.ouc.customerportal.model.Person;



/**
 * An utility class which contains useful methods for unit testing person related
 * functions.
 * 
 */
public class PersonTestUtil {

    public static PersonDTO createDTO(Long id, String firstName, String lastName) {
        PersonDTO dto = new PersonDTO();

        dto.setId(id);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);

        return dto;
    }

    public static Person createModelObject(Long id, String firstName, String lastName) {
        Person model = Person.getBuilder(firstName, lastName).build();
        model.setId(id);
        return model;
    }
}
