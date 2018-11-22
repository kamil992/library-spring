package library.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import library.models.form.RegisterForm;
import library.models.services.RegisterStatus;
import library.models.services.UserService;


@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/register")
	public String getRegister(Model model){
		model.addAttribute("userToRegister", new RegisterForm());
		return "registration";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("userToRegister") RegisterForm registerForm,
			BindingResult bindingResult,
			Model model){
		
		RegisterStatus register = userService.registerUser(registerForm);
		if(bindingResult.hasErrors()){
			return "registration";
		}
		
		if(register == RegisterStatus.BUSY_EMAIL){
			model.addAttribute("checkEmail","Account on this email already exists.");
			return "registration";
		}
		
		if(register == RegisterStatus.BUSY_LOGIN){
			model.addAttribute("checkLogin", "This login is already used by other user.");
			return "registration";
		}
		
		return "login";
	}

}
