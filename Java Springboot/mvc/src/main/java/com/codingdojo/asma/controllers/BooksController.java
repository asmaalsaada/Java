package com.codingdojo.asma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.asma.models.Book;
import com.codingdojo.asma.services.BookService;

//@RestController
//public class BooksApi {
//	private final BookService bookService;
//
//	public BooksApi(BookService bookService) {
//		this.bookService = bookService;
//	}
//
//	@RequestMapping("/api/books") // is not an API, must deal with db to become API..
//	public List<Book> index() {
//		return bookService.allBooks();
//	}
//
//	// create a new book 
//	@RequestMapping(value = "/api/books", method = RequestMethod.POST)
//	public Book create(@RequestParam(value = "title") String title, @RequestParam(value = "description") String desc,
//			@RequestParam(value = "language") String lang, @RequestParam(value = "pages") Integer numOfPages) {
//		Book book = new Book(title, desc, lang, numOfPages);
//		return bookService.createBook(book);
//	}
//	//get book by id
//	@RequestMapping("/api/books/{id}")
//	public Book show(@PathVariable("id") Long id) {
//		Book book = bookService.findBook(id);
//		return book;
//	}
//	//update book by id 
//	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
//	public Book update(@PathVariable("id") Long id, @RequestParam(value = "title") String title,
//			@RequestParam(value = "description") String desc, @RequestParam(value = "language") String lang,
//			@RequestParam(value = "pages") Integer numOfPages) {
//		Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
//		return book;
//	}
//	// delete book by id 
//	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.DELETE)
//	public void destroy(@PathVariable("id") Long id) {
//		bookService.deleteBook(id);
//	}
//}
@Controller
public class BooksController {
    private final BookService bookService;
    
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
    }
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
        }
        @RequestMapping("books/{id}")
        public String show(@PathVariable("id") Long id, Model model) {
        	Book book = bookService.findBook(id);
        	model.addAttribute("book", book);
        	return "show.jsp";
        }
    }
