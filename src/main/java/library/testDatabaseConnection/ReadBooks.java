package library.testDatabaseConnection;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import library.models.Book;


public class ReadBooks {
	
	@Autowired
	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		
		showAllBooks();
		

	}
	
public static void showAllBooks(){
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Book.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			session.beginTransaction();
			//Student student1 = session.get(Student.class, 4);
			List<Book> bookList = session
					.createQuery("from Book")
					.getResultList();
			
			for(Book b : bookList)
			System.out.println(b);
			
			session.getTransaction().commit();
			
		}finally{
			factory.close();
		}
	}

}
