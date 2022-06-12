package com.example.demo.mapper;

public class Usersql {
	public static final String LOGIN = "select * from user where userEmail = #{userEmail} and password = #{password}";
	public static final String GET_BORROWED_LIST = "select * from book where borrowedUser IN( select borrowedUser from user where userID = #{userID})";
	public static final String GET_RESERVED_LIST = "select * from book where reservedUser IN( select reservedUser from user where userID = #{userID})";
	public static final String GET_USER = "select * from user where userID = #{id}";
	public static final String GET_USER_OPTION = "SELECT * FROM user WHERE ${column}=#{value}";
}
