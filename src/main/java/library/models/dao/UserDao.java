package library.models.dao;

import library.models.entity.User;
import library.models.services.RegisterStatus;

public interface UserDao {
	
	public RegisterStatus registerUser(User user);
	
	public boolean existsByLogin(String login);
	public boolean existsByEmail(String email);

}
