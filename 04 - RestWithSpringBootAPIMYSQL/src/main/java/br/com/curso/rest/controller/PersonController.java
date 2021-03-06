package br.com.curso.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.rest.model.Person;
import br.com.curso.rest.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonServices services;

	@GetMapping(value = "/{id}")
	public Person findById(@PathVariable("id") Long id) {
		return services.findById(id);
	}

	@GetMapping()
	public List<Person> findAll() {
		return services.findAll();
	}

	@PostMapping()
	public Person create(@RequestBody Person person) {
		return services.create(person);
	}

	@PutMapping()
	public Person update(@RequestBody Person person) {
		return services.update(person);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Long id) {
		services.delete(id);
	}
}
