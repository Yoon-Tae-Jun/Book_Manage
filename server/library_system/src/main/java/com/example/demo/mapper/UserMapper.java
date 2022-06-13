package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.Book;
import com.example.demo.model.User;

@Mapper
public interface UserMapper {
	@Select(Usersql.LOGIN)
	User Login(@Param("userEmail") String userEmail, @Param("password") String password);
	
	@Select(Usersql.GET_BORROWED_LIST)
	List<Book> getBorrowedBook(@Param("userID") String userID);
	
	@Select(Usersql.GET_RESERVED_LIST)
	List<Book> getReservedBook(@Param("userID") String userID);
	
	@Select(Usersql.GET_USER)
	User getUser(@Param("id") String id);
	
	@Select(Usersql.GET_USER_OPTION)
	List<User> getUserOption(@Param("column") String column, @Param("value") String value);

	@Update(Usersql.UPDATE_OVERDUE)
	int updateOverdue(@Param("day") String day, @Param("id") String id);
		
	}
