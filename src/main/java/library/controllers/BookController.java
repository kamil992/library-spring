package library.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import library.models.entity.Author;
import library.models.entity.Book;
import library.models.services.AuthorService;
import library.models.services.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	
	
	@GetMapping("/books")
	public String getAllBooks(Model model){
		
		List<Book> booksList = bookService.getBooksList();
		
		model.addAttribute("booksList", booksList);
		
		return "books";
	}
	
	@GetMapping("/book/{bookId}")
	public String getBook(@PathVariable("bookId") int id,
						   Model model){
		
		Book book = bookService.getBook(id);
		try{
			model.addAttribute("book", book);
		}catch(NullPointerException e){
			return "books";
		}
		
		return "book";
	}
	
	@PostMapping("/search")
	public String searchBook(@RequestParam("searchingTitle") String searchingTitle,
							 Model model){
		
		List<Book> bookList = bookService.getSearchingBook(searchingTitle);
		model.addAttribute("booksList", bookList);
		
		return "books";
	}
	
	@GetMapping("/author/{authorId}")
	public String getAuthor(@PathVariable("authorId") int id,
							Model model){
	
		
		Author author = authorService.getAuthor(id);
		try{
			model.addAttribute("author", author);
		}catch(NullPointerException e){
			return "books";
		}

		//let's get all authors books
//		List<Book> booksList = bookService.getBooksList();
//		List<Book> list = getAuthorsBooks(booksList, id);	
		List<Book> list = bookService.getAuthorBooks(id);
		model.addAttribute("listOfBooks", list);
		
	
		return "/author";
	}
	
	
//	private static List<Book> getAuthorsBooks(List<Book> listOfBooks, int authorId){
//		List<Book> list = new ArrayList<>();
//		for(Book b : listOfBooks){
//			if(b.getAuthor().getId() == authorId){
//				list.add(b);
//			}
//		}
//		Collections.sort(list, (o1,o2) -> o1.getYear() - o2.getYear());
//		return list;
//	}
	
}
