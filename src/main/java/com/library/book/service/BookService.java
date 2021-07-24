package com.library.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.book.Book;
import com.library.book.exception.BookAlreadyExistsException;
import com.library.book.exception.BookNotFoundException;
import com.library.book.repository.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;

	@Autowired
	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	
	
	//GET
	public List<Book> getAllBooks()
	{
		if(bookRepository.findAll().equals(null)) 
			throw new BookNotFoundException();
		return bookRepository.findAll();
	}
	
	//GET
	public Book getBookById(int id)
	{
		if(!bookRepository.existsById(id)) 
			throw new BookNotFoundException();
		return bookRepository.findById(id).get();
	}
	
	//Post
	public Book saveBook(Book book)
	{
		if(!bookRepository.existsById(book.getId())) 
			return bookRepository.save(book);
		throw new BookAlreadyExistsException();
	}
	
	//PUT
	public Book updateBook(Book book)
	{
		if(!bookRepository.existsById(book.getId())) 
			throw new BookNotFoundException();
		return bookRepository.save(book);
	}
	
	//DELETE
	public void deleteBook(Book book)
	{
		if(!bookRepository.existsById(book.getId())) 
			throw new BookNotFoundException();
		bookRepository.delete(book);
	}
}