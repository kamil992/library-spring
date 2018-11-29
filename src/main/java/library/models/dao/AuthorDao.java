package library.models.dao;

import java.util.List;

import library.models.entity.Author;

public interface AuthorDao {
	
	Author getAuthor(int id);
	
	Author getAuthor(String fullName);
	
	List<Author> getAuthorList();

}
