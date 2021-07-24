package com.library.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.library.book.Book;
import com.library.book.service.BookService;

@RestController
public class BookController {

	private final BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@GetMapping("/books")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Book>> getAllBook()
	{
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Responded", "MyController");
		return ResponseEntity.accepted().headers(headers).body(bookService.getAllBooks());
	}
	
	@GetMapping("/books/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Book> getBook(@PathVariable("id") int id)
	{
		return ResponseEntity
				.ok()
				.header("ResponseHeader", "My Controller")
				.body(bookService.getBookById(id));
	}
	
	@PostMapping("/books")
	@ResponseStatus(HttpStatus.CREATED)
	public  Book saveBook(@RequestBody Book book)
	{
		return bookService.saveBook(book);
	}
	
	@PutMapping("/books")
	@ResponseStatus(HttpStatus.OK)
	public Book updateBook(@RequestBody Book book)
	{
		return bookService.updateBook(book);
	}
	
	@DeleteMapping("/books")
	@ResponseStatus(HttpStatus.OK)
	public String deleteBook(@RequestBody Book book)
	{
		bookService.deleteBook(book);
		return "Book Deleted";
	}
	
}
