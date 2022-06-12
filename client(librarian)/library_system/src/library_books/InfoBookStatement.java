package library_books;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InfoBookStatement {
	private boolean isBorrowed;
	private boolean isReserved;
	private String borrowedUser;	// 대출중인 사용자 id
	private String reservedUser;	// 예약중인 사용자 id
	private Date borrowedDate;		// 대출일
	private Date returnDate;		// 반납 예정일
	private int externDateCount;	// 대출 연장 횟수
	
	// 생성자, 초기화 =============================================================================================
	public InfoBookStatement(boolean isBorrowed, boolean isReserved, String borrowedUser, String reservedUser, Date borrowedDate, int externDateCount) {
		// 기존 도서 만들때(불러올때) 사용
		this.isBorrowed = isBorrowed;
		this.isReserved = isReserved;
		this.borrowedUser = borrowedUser;
		this.reservedUser = reservedUser;
		this.borrowedDate = borrowedDate;
		this.externDateCount = externDateCount;
		setReturnDate();	// 반납일 설정
	}
	public InfoBookStatement() {
		// 비어있는 정보 만들때 사용
		this.isBorrowed = true;
		this.isReserved = true;
		this.borrowedUser = null;
		this.reservedUser = null;
		this.borrowedDate = null;
		this.returnDate = null;
		this.externDateCount = 0;
	}

	//연장 횟수와 반납 예정일 연동
	public boolean updateExternDateCount(int externDateCount) {
		externDateCount--;
		if(externDateCount <= 0) {
			return false;
		}
		else {
			setReturnDate();
			return true;
		}
	}
	
	private void setReturnDate() {		// 반납일 설정
		Calendar cal = Calendar.getInstance();			// 캘린더 생성
		cal.setTime(returnDate);						// 캘린더 returnDate로 설정
        cal.add(Calendar.DATE, 7 * (-externDateCount+3));	// 날짜 계산
        returnDate = cal.getTime();		// 계산된 날짜 Date()객체로 저장
	}
	
	//getter, setter
	public boolean isBorrowed() {
		return isBorrowed;
	}
	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	public boolean isReserved() {
		return isReserved;
	}
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
	public String getBorrowedUser() {
		return borrowedUser;
	}
	public void setBorrowedUser(String borrowedUser) {
		this.borrowedUser = borrowedUser;
	}
	public String getReservedUser() {
		return reservedUser;
	}
	public void setReservedUser(String reservedUser) {
		this.reservedUser = reservedUser;
	}
	public String getBorrowedDate() {
		if(borrowedDate == null) return null; 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(borrowedDate);
	}
	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}
	public String getReturnDate() {
		if(returnDate == null) return null; 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(returnDate);
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate; 
	}
	public int getExternDateCount() {
		return externDateCount;
	}
	public void setExternDateCount(int externDateCount) {
		this.externDateCount = externDateCount;
	}
	
	public java.sql.Date GetSqlDate(String date) 	{
		return java.sql.Date.valueOf(date);
	}


}
