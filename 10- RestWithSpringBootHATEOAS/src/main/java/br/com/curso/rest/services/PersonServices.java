package br.com.curso.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.rest.converter.DozerConverter;
import br.com.curso.rest.converter.custom.PersonConverter;
import br.com.curso.rest.data.model.Person;
import br.com.curso.rest.data.vo.PersonVO;
import br.com.curso.rest.exception.ResourceNotFoundException;
import br.com.curso.rest.repository.PersonRepository;  
import br.com.curso.rest.data.vo.v2.PersonVOV2;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;
    
	@Autowired
	PersonConverter converter;
	
	public PersonVO create(PersonVO person) {
		Person entity = DozerConverter.parseObject(person, Person.class);
		PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVOV2 create2(PersonVOV2 person) {
		Person entity = converter.convertVOToEntity(person);
		PersonVOV2 vo = converter.convertEntityToVO(repository.save(entity));
		return vo;
	}
    
	public PersonVO findById(Long id) {
		Person entity =  repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}

	public List<PersonVO> findAll() {
		return DozerConverter.parseListsObjects(repository.findAll(), PersonVO.class);
	}

	public PersonVO update(PersonVO person) {
		Person entity = repository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
        PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
		repository.delete(entity);

	}

}
