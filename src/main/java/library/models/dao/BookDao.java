package library.models.dao;

import java.util.List;

import library.models.entity.Book;

public interface BookDao {
	
	public List<Book> getListOfBooks();
	
	//return all books of choosen author
	public List<Book> getAuthorBooks(int authorId);
	
	public Book getBook(int id);

}
