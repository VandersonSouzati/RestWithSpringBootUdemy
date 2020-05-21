package br.com.curso.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.rest.exception.ResourceNotFoundException;
import br.com.curso.rest.model.Person;
import br.com.curso.rest.repository.PersonRepository;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();

	@Autowired
	PersonRepository repository;

	public Person create(Person person) {
		return repository.save(person);
	}

	public Person findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}

	public List<Person> findAll() {
		return repository.findAll();
	}

	public Person update(Person person) {
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return repository.save(entity);
	}

	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
		repository.delete(entity);

	}

}
