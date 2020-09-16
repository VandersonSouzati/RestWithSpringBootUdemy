package br.com.curso.rest.converter.custom;

import br.com.curso.rest.data.vo.BookVO;
import br.com.curso.rest.data.model.Book;


//Como vou usar o DozerConverter não preciso fazer na mão a conversão, 
// Foi realizado um teste com a class PersonConverter, onde é usado o PersonVOV2
public class BookConverter {

	public BookVO convertEntityToVO(Book book) {
		BookVO bookVO = new BookVO();
		//bookVO.setId(book.getId());
		
		return null;
	}
	
	public Book convertVOToEntity(BookVO bookVO) {
		Book book = new Book();
		book.setId(bookVO.getKey());
		book.setAuthor(bookVO.getAuthor());
		book.setTitle(bookVO.getTitle());
		book.setPrice(bookVO.getPrice());
		book.setLaunchDate(bookVO.getLaunchDate());
		return book;
	}
}
