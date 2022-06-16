package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.Book;
import com.example.demo.model.User;

@Mapper
public interface UserMapper {
	//로그인
	@Select(Usersql.LOGIN)
	User Login(@Param("userEmail") String userEmail, @Param("password") String password);
	
	//대출 도서 가져오기
	@Select(Usersql.GET_BORROWED_LIST)
	List<Book> getBorrowedBook(@Param("userID") String userID);
	
	//예약 도서 가져오기
	@Select(Usersql.GET_RESERVED_LIST)
	List<Book> getReservedBook(@Param("userID") String userID);
	
	//유저 정보 가져오기
	@Select(Usersql.GET_USER)
	User getUser(@Param("id") String id);
	
	//유저 검색
	@Select(Usersql.GET_USER_OPTION)
	List<User> getUserOption(@Param("column") String column, @Param("value") String value);

	//연체 정보 업데이트
	@Update(Usersql.UPDATE_OVERDUE)
	int updateOverdue(@Param("day") String day, @Param("id") String id);
		
	//유저 삭제
	@Delete(Usersql.DELETE_USER)
	int deleteUser(@Param("id") String id);
	
	//유저 추가
	@Insert(Usersql.INSERT_USER)
	int insertUser(@Param("email") String email, @Param("password") String password, @Param("name") String name, @Param("type") String type );
	
	//유저 수정
	@Update(Usersql.UPDATE_USER)
	int updateUser(@Param("email") String email, @Param("password") String password, @Param("name") String name, @Param("id") String id);
	}
