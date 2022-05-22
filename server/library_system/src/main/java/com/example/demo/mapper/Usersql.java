package com.example.demo.mapper;

public class Usersql {
	public static final String LOGIN = "select * from user where userEmail = #{userEmail} and password = #{password}";
	public static final String GET_BORROWED_LIST = "select * from book where ownUser IN( select ownUser from user where userName = #{userName})";
}
