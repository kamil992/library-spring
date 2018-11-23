package library.models.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.CriteriaUpdateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.models.dao.UserDao;
import library.models.entity.User;
import library.models.services.RegisterStatus;

@Repository
public class UserRepository implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public RegisterStatus addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		
		List<User> userLogin = session.createQuery("from User where login='" + user.getLogin()+ "'", User.class)
				.getResultList();
		if(!userLogin.isEmpty()){
			return RegisterStatus.BUSY_LOGIN;
		}
		
		List<User> userEmail = session.createQuery("from User where email='" + user.getEmail()+ "'", User.class)
				.getResultList();
		if(!userEmail.isEmpty()){
			return RegisterStatus.BUSY_EMAIL;
		}
		
		User newUser = new User();
		
		session.save(newUser);
		return RegisterStatus.OK;
		
	}

	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		
		List<User> userList = session.createQuery("from User", User.class).getResultList();
		return userList;
	}

	//todo
	@Override
	public User getUser(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		
		User user = session
				.createQuery("from User where email='" + email + "' and password='" + password + "'", User.class)
				.getSingleResult();
		
		return user;	
	}

}
