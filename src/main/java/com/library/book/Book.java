package com.library.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.library.user.Borrower;

@Entity
@Table(name="book", schema="public")
public class Book{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="book_title")
	private String bookTitle;
	
	@Column(name="book_author")
	private String bookAuthor;
	
	@Column(name="book_genre")
	private String bookGenre;

	@ManyToOne
	@JoinColumn(name="borrowers")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Borrower borrower;
	

	public String getBookGenre() {
		return bookGenre;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public Book(int id, String bookAuthor, String bookTitle, String bookGenre) {
		this.id = id;
		this.bookAuthor = bookAuthor;
		this.bookTitle = bookTitle;
		this.bookGenre = bookGenre;
	}

	public Book() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}


}
