package br.com.curso.rest.controller;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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

import br.com.curso.rest.data.vo.PersonVO;
import br.com.curso.rest.data.vo.v2.PersonVOV2;
import br.com.curso.rest.services.PersonServices;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

	@Autowired
	PersonServices services;

	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<PersonVO> findAll() {
		List<PersonVO> persons =  services.findAll();
		persons.stream()
		          .forEach(
		        		    p->p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel())
		        		);
		List<PersonVO> p = new ArrayList<PersonVO>();
		
		PersonVO p1 = p.get(0);
		return p;
	}

	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO findById(@PathVariable("id") Long id) {
	    PersonVO personVO = services.findById(id);
	    personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
	    return personVO;
	}

	@PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
			     consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO create(@RequestBody PersonVO person) {
		PersonVO personVO =  services.create(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;
	}

	@PostMapping("/v2")
	public PersonVOV2 create2(@RequestBody PersonVOV2 personVOV2) {
		return services.create2(personVOV2);
	}

	@PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
			    consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO update(@RequestBody PersonVO person) {
		PersonVO personVO =  services.update(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Long id) {
        services.delete(id);

	}
}