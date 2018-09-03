package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import library.models.Book;


@Service
public class BookService {
	
	@Autowired
	library.dao.BookRepository bookRepository;
	
	@Transactional
	public List<Book> getBooksList(){
		
		return bookRepository.getListOfBooks();
	}

}
