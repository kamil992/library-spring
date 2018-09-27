package library.models.dao;

import java.util.List;

import library.models.entity.Book;

public interface BookDao {
	
	public List<Book> getListOfBooks();

}
