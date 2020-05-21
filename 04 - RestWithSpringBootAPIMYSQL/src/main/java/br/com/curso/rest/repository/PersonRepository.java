package br.com.curso.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.curso.rest.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
