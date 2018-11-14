package library.models.dao;

import library.models.form.RegisterForm;
import library.models.services.RegisterStatus;

public interface UserDao{
	
	public RegisterStatus registerUser(RegisterForm registerForm);
	
	public boolean existsByLogin(String login);
	public boolean existsByEmail(String email);

}
