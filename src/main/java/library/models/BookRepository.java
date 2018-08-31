package library.models;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository implements BookDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Book> getListOfBooks() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Book> booksFromDatabase = session.createQuery("from book order by title", Book.class);
		
		List<Book> listOfBooks = booksFromDatabase.getResultList();
		
		return listOfBooks;
	}

}
