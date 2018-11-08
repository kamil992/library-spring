package library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String getLogin(){
		return null;
	}
	
	@PostMapping("/login")
	public String postLogin(){
		return null;
	}
}
