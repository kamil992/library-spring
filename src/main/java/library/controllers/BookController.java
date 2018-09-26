package library.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import library.models.Author;
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
	
		Author author = authorService.getAuthor(id);

		//let's get all authors books
		List<Book> booksList = bookService.getBooksList();
		List<Book> list = getAuthorsBooks(booksList, id);	
		model.addAttribute("listOfBooks", list);
		
		
		try{
			model.addAttribute("author", author);
		}catch(NullPointerException e){
			return "books";
		}
	
		return "/author";
	}
	
	
	private static List<Book> getAuthorsBooks(List<Book> listOfBooks,int authorId){
		List<Book> list = new ArrayList<>();
		for(Book b : listOfBooks){
			if(b.getAuthor().getId() == authorId){
				list.add(b);
			}
		}
		return list;
	}
	
}
