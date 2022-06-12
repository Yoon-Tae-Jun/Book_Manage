package com.example.demo.mapper;

public class Booksql {
	public static final String SELECT_BOOK = "SELECT * FROM book WHERE BookId=#{id}";
	public static final String SELECT_BOOK_OPTION = "SELECT * FROM book WHERE ${column}=#{value}";
	public static final String SELECT_BOOK_ALL = "SELECT * FROM book";
	public static final String INSERT_BOOK = "INSERT INTO book VALUES(#{id}, #{bookName}, #{author}, #{genre}, true, true, NULL, NULL, NULL, 3)";
	public static final String BORROWED_BOOK = "UPDATE book SET isLoan= false, isReserve = false, borrowedUser=#{userID}, loanDate = #{loandate}, returnDate = #{returndate} WHERE BookId= #{bookID}";
	public static final String DELETE_BOOK = "DELETE FROM book WHERE BookId=#{id}";
}
