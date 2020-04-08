package library.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import library.models.services.NewBookStatus;
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
	public Model setModel(Model model) {
		model.addAttribute("isLogin", userService.isLogin());
		model.addAttribute("booksList", bookService.getBooksList());
		model.addAttribute("categories", categoryServce.getCategoryList());
		model.addAttribute("authorsList", authorService.getAuthorsList());
		if (userService.isLogin() == true) {
			model.addAttribute("userLogin", userService.getUser().getLogin());
		}

		return model;
	}

	@GetMapping("/")
	public String getAllBooks() {
		return "books";
	}

	@GetMapping("/{categoryName}")
	public String searchByCategory(@PathVariable("categoryName") String categoryName, Model model) {
		// to show all categories on main page
		List<Category> categoryList = categoryServce.getCategoryList();
		model.addAttribute("categories", categoryList);

		List<Book> booksOfCategories = categoryServce.findCategory(categoryName).getBooks();

		model.addAttribute("booksList", booksOfCategories);

		return "books";
	}

	@GetMapping("/book/{bookId}")
	public String getBook(@PathVariable("bookId") int id, Model model) {

		Book book = bookService.getBook(id);
		try {
			model.addAttribute("book", book);
		} catch (NullPointerException e) {
			return "books";
		}

		return "book";
	}

	@PostMapping("/search")
	public String searchBook(@RequestParam("searchingTitle") String searchingTitle, Model model) {

		List<Category> categoryList = categoryServce.getCategoryList();
		model.addAttribute("categories", categoryList);

		List<Book> bookList = bookService.getSearchingBook(searchingTitle);
		model.addAttribute("booksList", bookList);

		return "books";
	}

	@GetMapping("/author/{authorId}")
	public String getAuthor(@PathVariable("authorId") int id, Model model) {

		Author author = authorService.getAuthor(id);
		try {
			model.addAttribute("author", author);
		} catch (NullPointerException e) {
			return "books";
		}
		List<Book> list = bookService.getAuthorBooks(id);
		model.addAttribute("listOfBooks", list);

		return "/author";
	}
//	private static List<Book> getAuthorsBooks(List<Book> listOfBooks, int authorId){

	@GetMapping("/addBook")
	public String getNewBook(Model model) {
		model.addAttribute("newBook", new Book());

		return "newBook";
	}

	// todo validation
	@PostMapping("/addBook")
	public String addNewBook(@Valid @ModelAttribute("newBook") Book book, @RequestParam("authorName") String authorName,
			@RequestParam("categoryName") String categoryName, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", "You have empty places to fill.");
			return "newBook";
		}
		// set up author
		Author author = authorService.getAuthor(authorName);
		book.setAuthor(author);

		// set up category
		Category category = categoryServce.findCategory(categoryName);
		// get category from a list because of categories an book are many to many. in
		// feature a should something do with that ;/
		List<Category> categoryList = new ArrayList<Category>();
		categoryList.add(category);
		book.setCategories(categoryList);

		if (book.getPicture().equals("") || book.getPicture() == null) {
			book.setPicture(setUpImageToEmpty());
		}

		NewBookStatus bookStatus = bookService.addNewBook(book);

		if (bookStatus == bookStatus.ALREADY_EXIST) {
			model.addAttribute("checkIfExist", "Book already exists.");
			return "newBook";
		}

		return "redirect:/";
	}

	private static String setUpImageToEmpty() {
		String image = "https://upload.wikimedia.org/wikipedia/en/f/f9/No-image-available.jpg";
		return image;
	}
}
