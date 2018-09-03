package library.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.models.Book;

@Repository
public class BookRepository implements BookDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Book> getListOfBooks() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Book> booksFromDatabase = session.createQuery("from Book order by title", Book.class);
		
		List<Book> listOfBooks = booksFromDatabase.getResultList();
		
		return listOfBooks;
	}

}
