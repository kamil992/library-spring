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
import library.models.form.RegisterForm;
import library.models.services.RegisterStatus;

@Repository
public class UserRepository implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public RegisterStatus addUser(RegisterForm registerForm) {
		Session session = sessionFactory.getCurrentSession();
		
		List<User> userLogin = session.createQuery("from User where login='" + registerForm.getLogin()+ "'", User.class)
				.getResultList();
		if(!userLogin.isEmpty()){
			return RegisterStatus.BUSY_LOGIN;
		}
		
		List<User> userEmail = session.createQuery("from User where email='" + registerForm.getEmail()+ "'", User.class)
				.getResultList();
		if(!userEmail.isEmpty()){
			return RegisterStatus.BUSY_EMAIL;
		}
		
		User newUser = new User(registerForm);
		
		session.save(newUser);
		return RegisterStatus.OK;
		
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

	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		
		List<User> userList = session.createQuery("from User", User.class).getResultList();
		return userList;
	}

}
