package library.models.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.models.dao.BookDao;
import library.models.entity.Book;
import library.models.services.NewBookStatus;

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

	@Override
	public Book getBook(int id) {
		Session session = sessionFactory.getCurrentSession();	
		Book book = session.get(Book.class, id);
		
		return book;
	}

	@Override
	public List<Book> getAuthorBooks(int authorId) {		
		Session session = sessionFactory.getCurrentSession();		
		Query<Book> booksFromDatabase = session.createQuery("from Book where author_id=" + authorId + 
				"order by publication_year", Book.class);		
		List<Book> listOfBooks = booksFromDatabase.getResultList();
		
		return listOfBooks;
	}

	@Override
	public List<Book> searchBook(String searchingTitle) {		
		Session session = sessionFactory.getCurrentSession();
		Query query = null;	
		
		if(searchingTitle != null && searchingTitle.trim().length() > 0){
			query = session.createQuery("from Book where lower(title) like :searchingTitle", Book.class);
			query.setParameter("searchingTitle", "%" + searchingTitle.toLowerCase() + "%");
		}
		else{
			query = session.createQuery("from Book order by title", Book.class);
		}		
		List<Book> books = query.getResultList();
		
		return books;
	}

	@Override
	public NewBookStatus addNewBook(Book book) {
		Session session = sessionFactory.getCurrentSession();
		
		Book newBook = session.createQuery("from Book where title='" + book.getTitle()+"' and"
				+ " author_id='" + book.getAuthor().getId() + "'", Book.class).uniqueResult();
		if(newBook != null){
			return NewBookStatus.ALREADY_EXIST;
		}
		
		session.save(book);
		return NewBookStatus.OK;
	}

}
