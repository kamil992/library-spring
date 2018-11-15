package library.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import library.models.entity.User;
import library.models.form.RegisterForm;
import library.models.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;

@Service
public class UserService {
	
	@Getter @Setter
	private boolean isLogin;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public List<User> getUserList(){
		return userRepository.getAllUsers();
	}
	
	@Transactional
	public RegisterStatus registerUser(RegisterForm registerForm){
		return userRepository.registerUser(registerForm);
	}
	
	

}
