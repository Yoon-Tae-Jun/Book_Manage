package com.example.demo.mapper;

public class Booksql {
	public static final String SELECT_BOOK = "SELECT * FROM book WHERE BookId=#{id}";
	public static final String SELECT_BOOK_OPTION = "SELECT * FROM book WHERE ${column}=#{value}";
	public static final String SELECT_BOOK_ALL = "SELECT * FROM book";
	public static final String INSERT_BOOK = "insert into book (BookName, BookAuthor, BookGenre, PublicationYear, ImageURL) values (#{name}, #{author}, #{genre}, #{year}, #{url})";
	public static final String BORROWED_BOOK = "UPDATE book SET isLoan= false, isReserve = true, reservedUser = null, borrowedUser=#{userID}, loanDate = #{loandate}, returnDate = #{returndate} WHERE BookId= #{bookID}";
	public static final String RESERVED_BOOK = "UPDATE book SET isReserve= false, reservedUser=#{userID} WHERE BookId= #{bookID}";
	public static final String DELETE_BOOK = "DELETE FROM book where bookID = #{id};SET @count=0;UPDATE book SET bookID=@count:=@count+1;call reset_autoincrement('book')";
	public static final String CANCEL_RESERVED_BOOK = "UPDATE book SET isReserve= true, reservedUser=null WHERE BookId= #{bookID}";
	public static final String RETURN_BOOK = "UPDATE book SET isLoan = true, borrowedUser = null, loanDate = null, returnDate = null WHERE BookId= #{bookID}";
	public static final String EXTENSION_BOOK = "UPDATE book SET cntExtension = #{cnt}, returnDate = #{returnDate} WHERE BookId = #{bookID}";
	public static final String UPDATE_BOOK = "UPDATE book set BookName = #{name}, BookAuthor = #{author}, BookGenre = #{genre}, PublicationYear = #{year} WHERE BookId = #{bookID}";
	
}
