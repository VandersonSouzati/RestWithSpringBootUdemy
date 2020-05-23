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


import br.com.curso.rest.services.PersonServices;
import br.com.rest.data.vo.PersonVO;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonServices services;

	@GetMapping(value = "/{id}")
	public PersonVO findById(@PathVariable("id") Long id) {
		return services.findById(id);
	}

	@GetMapping()
	public List<PersonVO> findAll() {
		return services.findAll();
	}

	@PostMapping()
	public PersonVO create(@RequestBody PersonVO personVO) {
		return services.create(personVO);
	}

	@PutMapping()
	public PersonVO update(@RequestBody PersonVO personVO) {
		return services.update(personVO);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Long id) {
		services.delete(id);
	}
}