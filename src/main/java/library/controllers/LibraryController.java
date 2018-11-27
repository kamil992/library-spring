package library.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import library.models.entity.Author;
import library.models.entity.Book;
import library.models.entity.Category;
import library.models.services.AuthorService;
import library.models.services.BookService;
import library.models.services.CategoryService;
import library.models.services.UserService;

@Controller
public class LibraryController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private CategoryService categoryServce;
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public Model setModel(Model model){
		model.addAttribute("isLogin", userService.isLogin());
		model.addAttribute("booksList", bookService.getBooksList());
		model.addAttribute("categories", categoryServce.getCategoryList());
		//model.addAttribute("userLogin", userService.getUser().getLogin());
	
		return model;	
	}
	
	@GetMapping("/")
	public String getAllBooks(){			
		return "books";
	}
	
	@GetMapping("/{categoryName}")
	public String searchByCategory(@PathVariable("categoryName") String categoryName,
								Model model){
		//to show all categories on main page
	    List<Category> categoryList = categoryServce.getCategoryList();
		model.addAttribute("categories", categoryList);
		
		List<Book> booksOfCategories = categoryServce.findCategory(categoryName).getBooks();
		
		model.addAttribute("booksList", booksOfCategories);
		
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
		
		List<Category> categoryList = categoryServce.getCategoryList();
		model.addAttribute("categories", categoryList);
		
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
