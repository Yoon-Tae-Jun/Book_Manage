package com.example.demo.mapper;

public class Usersql {
	public static final String LOGIN = "select * from user where userEmail = #{userEmail} and password = #{password}";
	public static final String GET_BORROWED_LIST = "select * from book where borrowedUser IN( select borrowedUser from user where userID = #{userID})";
	public static final String GET_RESERVED_LIST = "select * from book where reservedUser IN( select reservedUser from user where userID = #{userID})";
	public static final String GET_USER = "select * from user where userID = #{id}";
	public static final String GET_USER_OPTION = "SELECT * FROM user WHERE ${column}=#{value}";
	public static final String UPDATE_OVERDUE = "UPDATE user SET overdueDay = #{day} WHERE userID = #{id}";
	public static final String DELETE_USER = "DELETE FROM user where userID = #{id};SET @count=0;UPDATE user SET userID=@count:=@count+1;call user_reset_autoincrement('user')";
	public static final String INSERT_USER = "insert into user (userEmail, password, userName, userType) values (#{email}, #{password}, #{name}, #{type})";
	public static final String UPDATE_USER = "UPDATE user set userEmail = #{email}, password = #{password}, userName = #{name} WHERE userID = #{id}";
}
