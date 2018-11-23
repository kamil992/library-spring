package library.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import library.models.entity.User;
import library.models.repository.UserRepository;

@Service
public class UserService {
	
	
	private boolean isLogin;
	
	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public List<User> getUserList(){
		return userRepository.getAllUsers();
	}
	
	@Transactional
	public RegisterStatus registerUser(User user){
		return userRepository.addUser(user);
	}
	
	@Transactional
	public User getUser(String email, String password){
		return userRepository.getUser(email, password);
	}
	

}
