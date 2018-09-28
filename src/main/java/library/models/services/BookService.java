package library.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import library.models.entity.Book;


@Service
public class BookService {
	
	@Autowired
	private library.models.repository.BookRepository bookRepository;
	
	@Transactional
	public List<Book> getBooksList(){		
		return bookRepository.getListOfBooks();
	}
	
	@Transactional
	public Book getBook(int id){
		return bookRepository.getBook(id);
	}
	
	//return all books of choosen author
	@Transactional
	public List<Book> getAuthorBooks(int authorId){	
		return bookRepository.getAuthorBooks(authorId);
	}
	
	@Transactional
	public List<Book> getSearchingBook(String searchingTitle){	
		return bookRepository.searchBook(searchingTitle);
	}

}
