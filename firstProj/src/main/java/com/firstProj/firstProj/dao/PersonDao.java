package com.firstProj.firstProj.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.firstProj.firstProj.model.Person;


public interface PersonDao {

	int insertPerson(UUID id, Person person);
	
	List<Person> getAllPerson();
	
	Optional<Person> getPersonById(UUID id);
	
	int updatePersonById(UUID id, Person person);
	
	int deletePersonById(UUID id);
}
