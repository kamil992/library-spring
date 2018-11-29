package library.models.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

	@Override
	public Author getAuthor(String fullName) {
		Session session = sessionFactory.getCurrentSession();
		Author author = session.createQuery("from Author where full_name='" + fullName + "'", 
				Author.class).uniqueResult();
		
		return author;
	}

	@Override
	public List<Author> getAuthorList() {
		Session session = sessionFactory.getCurrentSession();		
		Query<Author> authors = session.createQuery("from Author", Author.class);
		List<Author> listOfAuthors = authors.getResultList();
		
		return listOfAuthors;
	}
	

}
