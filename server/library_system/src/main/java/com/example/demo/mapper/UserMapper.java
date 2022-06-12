package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.Book;
import com.example.demo.model.User;

@Mapper
public interface UserMapper {
	@Select(Usersql.LOGIN)
	User Login(@Param("userEmail") String userEmail, @Param("password") String password);
	
	@Select(Usersql.GET_BORROWED_LIST)
	List<Book> getBorrowedBook(@Param("userName") String userName);
	
	@Select(Usersql.GET_USER)
	User getUser(@Param("id") String id);
}