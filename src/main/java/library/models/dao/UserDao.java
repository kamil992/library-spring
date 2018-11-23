package library.models.dao;

import java.util.List;

import library.models.entity.User;
import library.models.services.RegisterStatus;

public interface UserDao{
	
	public List<User> getAllUsers();
	public RegisterStatus addUser(User user);
	public User getUser(String email, String password);
}
