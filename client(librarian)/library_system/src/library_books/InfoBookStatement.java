package library_books;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InfoBookStatement {
	
	private String borrowedUser;	// 대출중인 사용자 id
	private String reservedUser;	// 예약중인 사용자 id
	private Date borrowedDate;		// 대출일
	private Date returnDate;		// 반납 예정일
	private int externDateCount;	// 대출 연장 횟수
	public static final int MAX_externDate = 2;		// 최대 연장 횟수
	
	// 생성자, 초기화 =============================================================================================
	public InfoBookStatement(String borrowedUser, String reservedUser, Date borrowedDate, int externDateCount) {
		// 기존 도서 만들때(불러올때) 사용
		this.borrowedUser = borrowedUser;
		this.reservedUser = reservedUser;
		this.borrowedDate = borrowedDate;
		this.externDateCount = externDateCount;
		setReturnDate();	// 반납일 설정
	}
	public InfoBookStatement() {
		// 비어있는 정보 만들때 사용
		this.borrowedUser = null;
		this.reservedUser = null;
		this.borrowedDate = null;
		this.returnDate = null;
		this.externDateCount = 0;
	}
	public InfoBookStatement(InfoBookStatement ibs) {
		// 기존 객체로 책 정보 초기화
		this.borrowedUser = ibs.borrowedUser;
		this.reservedUser = ibs.reservedUser;
		this.borrowedDate = ibs.borrowedDate;
		this.returnDate = ibs.returnDate;
		this.externDateCount = ibs.externDateCount;
	}
	
	// 도서 상태 정보 반환 ==========================================================================================
	public String 	getBorrowedUser() 	{return borrowedUser;}
	public String 	getReservedUser() 	{return reservedUser;}
	public String 	getBorrowedDate() {
		if(borrowedDate == null) return "대출상태 아님";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(borrowedDate);
	}
	public String 	getReturnDate() {
		if(returnDate == null) return "예약상태 아님";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(returnDate);
	}
	public int		getExternDateCount() {return externDateCount;}
	
	// 도서 상태 정보 수정 ==========================================================================================
	public void updateBorrowedUser(String borrowedUser) 	{this.borrowedUser = borrowedUser;}
	public void updateReservedUser(String reservedUser)		{this.reservedUser = reservedUser;}
	public void updateBorrowedDate()						{this.borrowedDate = new Date();}
	public void updateExternDateCount(int externDateCount)	{
		this.externDateCount = externDateCount;
		setReturnDate();	// 연장횟수를 늘리면, 반납일도 늘어남
	}
	private void setReturnDate() {		// 반납일 설정
		Calendar cal = Calendar.getInstance();			// 캘린더 생성
		cal.setTime(returnDate);						// 캘린더 returnDate로 설정
        cal.add(Calendar.DATE, 7 * (externDateCount+1));	// 날짜 계산
        returnDate = cal.getTime();		// 계산된 날짜 Date()객체로 저장
	}
}
