package com.firstProj.firstProj.api;

import java.util.List;
import java.util.UUID;

import com.firstProj.firstProj.model.Person;
import com.firstProj.firstProj.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

	private final PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService=personService;
	}
	
	@PostMapping
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}
	
	@GetMapping
	public List<Person> getAllPerson() {
		return personService.getAllPerson();
	}
	
	@GetMapping(path="{id}")
	public Person getPersonById(@PathVariable("id") UUID id) {
		return personService.getPersonById(id).orElse(null);
	}
	
	@PutMapping(path="{id}")
	public void updatePersonById(@PathVariable("id") UUID id, @RequestBody Person personToUpdate) {
		personService.updatePersonById(id, personToUpdate);
	}
	
	@DeleteMapping(path="{id}")
	public void deletePersonById(@PathVariable("id") UUID id) {
		personService.deletePersonById(id);
	}
}
