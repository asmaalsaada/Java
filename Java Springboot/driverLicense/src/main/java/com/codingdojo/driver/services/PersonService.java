package com.codingdojo.driver.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.driver.models.Person;
import com.codingdojo.driver.repository.PersonRepository;
@Service
public class PersonService {
	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		
		this.personRepository = personRepository;
	}

	//get all persons
	public List<Person> allPerson(){
		return personRepository.findAll();
	}
	//create a person object
	public Person create(Person p) {
		return personRepository.save(p);
	}
	//retrieve a person details
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id); 
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
		} // return personRepository.findById(id).orElse(null);
	//get null license
		public List<Person> isNullLicense(){
			return personRepository.findByLicenseIdIsNull();
}

		public Person findById(Long id) {
			Optional<Person> optionalPerson = personRepository.findById(id);
			if (optionalPerson.isPresent()) {
				return optionalPerson.get();
			} else {
				return null;
			}
		}
		}

