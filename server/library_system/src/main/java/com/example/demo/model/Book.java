package com.example.demo.model;

public class Book {
	private String BookId;
	private String BookName;
	private String BookAuthor;
	private int BookGenre;
	private boolean isLoan;
	private boolean isReserve;
	private String ownUser;
	private String ImageURL;

	public Book(String BookId, String BookName, String BookAuthor, int BookGenre, boolean isLoan, boolean isReserve,
			String ownUser, String ImageURL) {
		super();
		this.BookId = BookId;
		this.BookName = BookName;
		this.BookAuthor = BookAuthor;
		this.BookGenre = BookGenre;
		this.isLoan = isLoan;
		this.isReserve = isReserve;
		this.ownUser = ownUser;
		this.ImageURL = ImageURL;
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
	public String getImageURL() {
		return ImageURL;
	}
	public void setImageURL(String imageURL) {
		ImageURL = imageURL;
	}
	
	
}
