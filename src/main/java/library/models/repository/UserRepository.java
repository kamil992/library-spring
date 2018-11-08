package library.models.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.models.dao.UserDao;
import library.models.entity.User;
import library.models.services.RegisterStatus;

@Repository
public class UserRepository implements UserDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public RegisterStatus registerUser(User user) {
		
		return null;
	}

	@Override
	public boolean existsByLogin(String login) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> user = session.createQuery("",User.class);
		return false;
	}

	@Override
	public boolean existsByEmail(String email) {
		
		return false;
	}

}
