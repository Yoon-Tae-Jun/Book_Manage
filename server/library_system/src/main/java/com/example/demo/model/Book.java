package com.example.demo.model;
import java.sql.Date;

public class Book {
	private String BookId;
	private String BookName;
	private String BookAuthor;
	private int BookGenre;
	private boolean isBorrowed;
	private boolean isReserved;
	private String BorrowedUser;
	private String reservedUser;
	private Date BorrowedDate;
	private Date returnDate;
	private int cntExtension;
	private String ImageURL;
	private String PublicationYear;
	
	public Book(String BookId, String BookName, String BookAuthor, int BookGenre, boolean isBorrowed, boolean isReserved,
			String BorrowedUser,String reservedUser,Date BorrowedDate,Date returnDate,int cntExtension, String ImageURL, String PublicationYear) {
		super();
		this.BookId = BookId;
		this.BookName = BookName;
		this.BookAuthor = BookAuthor;
		this.BookGenre = BookGenre;
		this.isBorrowed = isBorrowed;
		this.isReserved = isReserved;
		this.BorrowedUser = BorrowedUser;
		this.reservedUser = reservedUser;
		this.BorrowedDate = BorrowedDate;
		this.returnDate = returnDate;
		this.cntExtension = cntExtension;
		this.ImageURL = ImageURL;
		this.PublicationYear = PublicationYear;
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
	public boolean isBorrowed() {
		return isBorrowed;
	}
	public void setBorrowed(boolean isLoan) {
		this.isBorrowed = isLoan;
	}
	public boolean isReserved() {
		return isReserved;
	}
	public void setReserved(boolean isReserve) {
		this.isReserved = isReserve;
	}

	public String getImageURL() {
		return ImageURL;
	}
	public void setImageURL(String imageURL) {
		ImageURL = imageURL;
	}

	public String getPublicationYear() {
		return PublicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		PublicationYear = publicationYear;
	}

	public String getBorrowedUser() {
		return BorrowedUser;
	}

	public void setBorrowedUser(String borrowedUser) {
		this.BorrowedUser = borrowedUser;
	}

	public String getReservedUser() {
		return reservedUser;
	}

	public void setReservedUser(String reservedUser) {
		this.reservedUser = reservedUser;
	}

	public Date getBorrowedDate() {
		return BorrowedDate;
	}

	public void setBorrowedDate(Date loanDate) {
		this.BorrowedDate = loanDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getCntExtension() {
		return cntExtension;
	}

	public void setCntExtension(int cntExtension) {
		this.cntExtension = cntExtension;
	}
	
	
}
