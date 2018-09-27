package library.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import library.models.entity.Book;


@Service
public class BookService {
	
	@Autowired
	private library.models.dao.BookRepository bookRepository;
	
	@Transactional
	public List<Book> getBooksList(){
		
		return bookRepository.getListOfBooks();
	}

}
