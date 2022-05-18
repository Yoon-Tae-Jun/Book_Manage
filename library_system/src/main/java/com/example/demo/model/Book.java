package com.example.demo.model;

public class Book {
	public Book(String bookId, String bookName, String bookAuthor, int bookGenre) {
		super();
		BookId = bookId;
		BookName = bookName;
		BookAuthor = bookAuthor;
		BookGenre = bookGenre;
	}
	private String BookId;
	private String BookName;
	private String BookAuthor;
	private int BookGenre;
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getBookAuthor() {
		return BookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}
	public int getBookGenre() {
		return BookGenre;
	}
	public void setBookGenre(int bookGenre) {
		BookGenre = bookGenre;
	}
	
	
}
