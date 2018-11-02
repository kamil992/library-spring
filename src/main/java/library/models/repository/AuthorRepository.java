package library.models.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.models.dao.AuthorDao;
import library.models.entity.Author;

@Repository
public class AuthorRepository implements AuthorDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Author getAuthor(int id) {	
		Session session = sessionFactory.getCurrentSession();	
		Author author = session.get(Author.class, id);
		
		return author;
	}

}