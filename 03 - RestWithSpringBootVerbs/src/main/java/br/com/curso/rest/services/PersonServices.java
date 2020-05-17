package br.com.curso.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.curso.rest.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();

	
	public Person create(Person person) {
	    person.setOperation("Created");
		return person;
	}
	
	public Person update(Person person) {
		person.setOperation("Updated");
		return person;
	}
	
	public void delete(String id) {
	   	
	}
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Vanderson");
		person.setLastName("Souza");
		person.setAddress("Santa Barbara d'Oeste -> São Paulo - Brasil");
		person.setGender("Male");

		return person;
	}

	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	public Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person_" + i);
		person.setLastName("Sobre Nome" + i);
		person.setAddress("End " + i);
		person.setGender("Gender_ " + i);
		person.setOperation("");

		return person;
	}

}
