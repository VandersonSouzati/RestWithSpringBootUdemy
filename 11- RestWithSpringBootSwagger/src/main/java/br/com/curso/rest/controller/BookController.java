package br.com.curso.rest.controller;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.rest.data.vo.BookVO;
import br.com.curso.rest.services.BookServices;

@RestController
@RequestMapping("/api/book/v1")
public class BookController {

	@Autowired
	BookServices services;

	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<BookVO> findAll() {
		List<BookVO> books = services.findAll();
		books.stream()
		     .forEach( b-> b.add(
		    	       linkTo(methodOn(BookController.class).findById(b.getKey())).withSelfRel()
		    	      )
		    );
		return books;
	}

	@GetMapping(value="/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO findById(@PathVariable("id") Long id) {
		BookVO bookVO = services.findById(id);
		bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return bookVO;
	}

	@PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
	             consumes = {"application/json", "application/xml", "application/x-yaml"}) 
	public BookVO create(@RequestBody BookVO bookVO) {
		BookVO book = services.create(bookVO);
		book.add(linkTo(methodOn(BookController.class).findById(book.getKey())).withSelfRel());
		return book;
	}

	@PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
			    consumes = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO update(@RequestBody BookVO bookVO) {
		BookVO book = services.create(bookVO);
		book.add(linkTo(methodOn(BookController.class).findById(book.getKey())).withSelfRel());
		return book;
	}

	@DeleteMapping(value="{id}")
	public void delete(@PathVariable("id") Long id) {
		services.delete(id);
	}
}
