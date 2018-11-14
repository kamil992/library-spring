package library.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import library.models.entity.User;
import library.models.form.RegisterForm;
import library.models.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public RegisterStatus registerUser(RegisterForm registerForm){
		return userRepository.registerUser(registerForm);
	}

}
