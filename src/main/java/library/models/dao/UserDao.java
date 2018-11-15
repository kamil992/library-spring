package library.models.dao;

import java.util.List;

import library.models.entity.User;
import library.models.form.RegisterForm;
import library.models.services.RegisterStatus;

public interface UserDao{
	
	public List<User> getAllUsers();
	
	public RegisterStatus registerUser(RegisterForm registerForm);
	
	public boolean existsByLogin(String login);
	public boolean existsByEmail(String email);

}
