package library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import library.models.Book;
import library.services.AuthorService;
import library.services.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	
	@GetMapping("/books")
	public String getBooks(Model model){
		
		List<Book> booksList = bookService.getBooksList();
		
		model.addAttribute("booksList", booksList);
		
		return "books";
	}
	
	@GetMapping("/author/{authorId}")
	public String getAuthor(@PathVariable("authorId") int id,
							Model model){
		
		
		model.addAttribute("bookList", authorService.getAuthor(id).getBooksList());
		
		try{
			model.addAttribute("author", authorService.getAuthor(id));
		}catch(NullPointerException e){
			return "books";
		}
	
		return "/author";
	}
	
}
