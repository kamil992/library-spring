package library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String getLogin(Model model){
		
		return "login";
	}
	
	@PostMapping("/login")
	public String postLogin(@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model){
		
		model.addAttribute("loginUser", "");
		return "redirect:/";
	}
}
