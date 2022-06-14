package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.Book;
import com.example.demo.mapper.Booksql;

@Mapper
public interface BookMapper {

	@Select(Booksql.SELECT_BOOK)
	Book getBook(@Param("id") String id);
	
	@Select(Booksql.SELECT_BOOK_ALL)
	List<Book> getBookList();
	
	@Select(Booksql.SELECT_BOOK_OPTION)
	List<Book> getBookOption(@Param("column") String column, @Param("value") String value);
	
	@Insert(Booksql.INSERT_BOOK)
	int insertBook(@Param("id") String id,@Param("bookName") String bookName, @Param("author") String Author, @Param("genre") int genre);
	
	@Update(Booksql.BORROWED_BOOK)
	int borrowedBook(@Param("userID") String userID, @Param("loandate") String loandate, @Param("returndate") String returndate, @Param("bookID") String bookID);
	
	@Update(Booksql.RESERVED_BOOK)
	int reservedBook(@Param("userID") String userID, @Param("bookID") String bookID);

	@Delete(Booksql.DELETE_BOOK)
	int deleteBook(@Param("id") String id);
	
	@Update(Booksql.BORROWED_BOOK)
	void completeReserved();
	
	@Update(Booksql.CANCEL_RESERVED_BOOK)
	int cancelReservedBook(@Param("bookID") String bookID);
	
	@Update(Booksql.RETURN_BOOK)
	int returnBook(@Param("bookID") String bookID);
	
	@Update(Booksql.EXTENSION_BOOK)
	int extension(@Param("cnt") int cnt, @Param("returnDate") String returnDate, @Param("bookID") String bookID);
}
