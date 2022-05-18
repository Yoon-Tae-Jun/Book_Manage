package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.Book;

@Mapper
public interface BookMapper {

	@Select("SELECT * FROM book WHERE BookId=#{id}")
	Book getBook(@Param("id") String id);
	
	@Select("SELECT * FROM book")
	List<Book> getBookList();
	
	@Insert("INSERT INTO book VALUES(#{id}, #{bookName}, #{author}, #{genre}, true, true, NULL, NULL, NULL, 3)")
	int insertBook(@Param("id") String id,@Param("bookName") String bookName, @Param("author") String Author, @Param("genre") int genre);
	
	@Update("UPDATE book SET BookId=#{id}, BookName=#{bookName},BookAuthor =#{author}, BookGenre = #{genre} WHERE BookId= #{id}")
	int updateBook(@Param("id") String id,@Param("bookName") String bookName, @Param("author") String Author, @Param("genre") int genre);
	
	@Delete("DELETE FROM book WHERE BookId=#{id}")
	int deleteBook(@Param("id") String id);
}
