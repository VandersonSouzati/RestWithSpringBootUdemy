package br.com.curso.rest.converter.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.curso.rest.data.model.Person;
import br.com.curso.rest.data.vo.v2.PersonVOV2;


@Service
public class PersonConverter {
   
	public PersonVOV2 convertEntityToVO(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setAddress(person.getAddress());
		vo.setBirthday(new Date());
		vo.setGender(person.getGender());
		vo.setOperation(person.getOperation());
		
		return vo;
	}
	
	public Person convertVOToEntity(PersonVOV2 personVO) {
		Person entity = new Person();
		entity.setId(personVO.getId());
		entity.setFirstName(personVO.getFirstName());
		entity.setLastName(personVO.getLastName());
		entity.setAddress(personVO.getAddress());
		entity.setGender(personVO.getGender());
		entity.setOperation(personVO.getOperation());
		
		return entity;
	}
}
