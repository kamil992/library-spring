package library.models.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.models.Book;
import library.models.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	@Transactional
	public List<Book> getBooksList(){
		
		return bookRepository.getListOfBooks();
	}

}
