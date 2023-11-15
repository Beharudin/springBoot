package com.firstProj.firstProj.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.firstProj.firstProj.dao.PersonDao;
import com.firstProj.firstProj.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	private final PersonDao personDao;

	@Autowired
	public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
		this.personDao = personDao;
	}

	public int addPerson(Person person) {
		UUID id = UUID.randomUUID();
		return personDao.insertPerson(id, person);
	}
	
	public List<Person> getAllPerson() {
		return personDao.getAllPerson();
	}
	
	public Optional<Person> getPersonById(UUID id) {
		return personDao.getPersonById(id);
	}
	
	public int updatePersonById(UUID id, Person person) {
		return personDao.updatePersonById(id, person);
	}
	
	public int deletePersonById(UUID id) {
		return personDao.deletePersonById(id);
	}
}
