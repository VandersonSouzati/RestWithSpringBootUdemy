package br.com.curso.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.rest.converter.DozerConverter;
import br.com.curso.rest.data.model.Book;
import br.com.curso.rest.data.vo.BookVO;
import br.com.curso.rest.exception.ResourceNotFoundException;
import br.com.curso.rest.repository.BookRepository;

@Service
public class BookServices {
	
	@Autowired
	BookRepository repository;
	
	/*
	@Autowired
	DozerConverter converter;
	*/
	
	public List<BookVO> findAll(){
		return DozerConverter.parseListsObjects(repository.findAll(),BookVO.class);
	}
	
	
	public BookVO findById(Long id) {
	   Book entity = repository.findById(id).orElseThrow(
			       ()-> new ResourceNotFoundException("NO records founds this ID")
			      );
	   return DozerConverter.parseObject(entity, BookVO.class);
	}
	
	
	public BookVO create(BookVO bookVO) {
		Book entity = DozerConverter.parseObject(bookVO, Book.class);
		System.out.println(entity.getLaunchDate() + " Data Service -> " + "Data VO "+bookVO.getLaunchDate() + "----"+entity.getAuthor());
		BookVO vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}
	
	
	public BookVO update(BookVO bookVO) {
		Book entity = repository.findById(bookVO.getKey()).orElseThrow(
				   () -> new ResourceNotFoundException("No records found this ID")
				);
	    entity.setAuthor(bookVO.getAuthor());
	    entity.setLaunchDate(bookVO.getLaunchDate());
	    entity.setPrice(bookVO.getPrice());
	    entity.setTitle(bookVO.getTitle());
	    
	    return DozerConverter.parseObject(repository.save(entity), BookVO.class);
	}
	
	public void delete(Long id) {
		Book entity = repository.findById(id).orElseThrow(
				  ()-> new ResourceNotFoundException("No records found this ID")); 
		repository.delete(entity);
	}

}
