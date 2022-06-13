package com.example.demo.model;

public class User {

	private String userID;
	private String userEmail;
	private String password;
	private String userName;
	private String userType;
	private int maxBorrowedCount;
	private int maxReservedCount;
	private int overdueDay;
	public User(String userID, String userEmail, String password, String userName, String userType,
			int maxBorrowedCount, int maxReservedCount, int overdueDay) {
		super();
		this.userID = userID;
		this.userEmail = userEmail;
		this.password = password;
		this.userName = userName;
		this.userType = userType;
		this.maxBorrowedCount = maxBorrowedCount;
		this.maxReservedCount = maxReservedCount;
		this.overdueDay = overdueDay;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getMaxBorrowedCount() {
		return maxBorrowedCount;
	}
	public void setMaxBorrowedCount(int maxBorrowedCount) {
		this.maxBorrowedCount = maxBorrowedCount;
	}
	public int getMaxReservedCount() {
		return maxReservedCount;
	}
	public void setMaxReservedCount(int maxReservedCount) {
		this.maxReservedCount = maxReservedCount;
	}
	
	public int getOverdueDay() {
		return overdueDay;
	}
	
	public void setOverdueDay(int overdueDay) {
		this.overdueDay = overdueDay;
	}
	
	
}
