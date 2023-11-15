package com.firstProj.firstProj.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.firstProj.firstProj.model.Person;
import org.springframework.stereotype.Repository;


@Repository("fakeDao")
public class PersonDataAccessService implements PersonDao{
	
	private static List<Person> DB=new ArrayList<>();

	@Override
	public int insertPerson(UUID id, Person person) {
		DB.add(new Person(id, person.getName()));
		return 1;
	}

	
	@Override
	public List<Person> getAllPerson() {
		return DB;
	}
	
	@Override
	public Optional<Person> getPersonById(UUID id) {
		return DB.stream()
				.filter(person->person.getId().equals(id))
				.findFirst();
	}
	
	@Override
	public int updatePersonById(UUID id, Person person) {
		return getPersonById(id)
				.map(p->{
					int indexOfPersonToUpdate=DB.indexOf(p);
					
					if(indexOfPersonToUpdate>=0) {
						DB.set(indexOfPersonToUpdate, new Person(id, person.getName()));
						return 1;
					}
					return 0;
				}).orElse(0);
	}
	
	@Override
	public int deletePersonById(UUID id) {
		Optional<Person> personMayBe=getPersonById(id);
		if(personMayBe.isEmpty())
			return 0;
		DB.remove(personMayBe.get());
		return 1;
	}
}
