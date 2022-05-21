package com.example.demo.model;

public class Book {

	private String BookId;
	private String BookName;
	private String BookAuthor;
	private int BookGenre;
	private boolean isLoan;
	private boolean isReserve;
	private String ownUser;
	public Book(String bookId, String bookName, String bookAuthor, int bookGenre) {
		super();
		BookId = bookId;
		BookName = bookName;
		BookAuthor = bookAuthor;
		BookGenre = bookGenre;
	}
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
	public boolean isLoan() {
		return isLoan;
	}
	public void setLoan(boolean isLoan) {
		this.isLoan = isLoan;
	}
	public boolean isReserve() {
		return isReserve;
	}
	public void setReserve(boolean isReserve) {
		this.isReserve = isReserve;
	}
	public String getOwnUser() {
		return ownUser;
	}
	public void setOwnUser(String ownUser) {
		this.ownUser = ownUser;
	}
	
	
}
