package library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import library.models.Book;
import library.services.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	@GetMapping("/books")
	public String getBooks(Model model){
		
		List<Book> booksList = bookService.getBooksList();
		
		model.addAttribute("booksList", booksList);
		
		return "books";
	}
	
}
