package library.models.dao;

import java.util.List;

import library.models.entity.Book;
import library.models.services.NewBookStatus;

public interface BookDao {
	
	public List<Book> getListOfBooks();
	
	//return all books of choosen author
	public List<Book> getAuthorBooks(int authorId);
	
	public Book getBook(int id);
	
	public List<Book> searchBook(String searchingKey);
	
	public NewBookStatus addNewBook(Book book);

}
