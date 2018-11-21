package library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import library.models.entity.User;
import library.models.services.UserService;


@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String getLogin(Model model){
		
		return "login";
	}
	
	//todo
	@PostMapping("/login")
	public String postLogin(@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model){
		User user;
		try{
			user = userService.getUser(email, password);
			model.addAttribute("userLogin", user.getLogin());
			userService.setLogin(true);
		}
		catch(Exception e){
			model.addAttribute("userNotFound", "You entered incorrect email or password!");
			return "login";
		}
		
		return "redirect:/";
	}
}
