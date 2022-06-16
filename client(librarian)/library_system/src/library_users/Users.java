package library_users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import library_books.Book;

// 사용자 : Users
// 전체 사용자 클래스
// @건아
public class Users {
	private String id;
	private String email;
	private String pw;
	private String name;
	private String userType;		// Patron, Librarian, Manager
	private int borrowedCount;						// 대출한 도서 수
	private ArrayList<Book> borrowedBook;			// 대출한 도서 목록 (도서 id(String))
	private int reservedCount;						// 예약한 도서 수
	private ArrayList<Book> reservedBook;			// 예약된 도서 목록 (도서 id(String))
	private int overdueCount;						// 연체된 도서 수
	private ArrayList<Book> overdueBook; 			// 연체된 도서 목록 (도서 id(String))
	private int MAX_borrowedCount;		// 최대 대출 가능 갯수
	private int MAX_reservedCount;		// 최대 예약 가능 갯수
	
	// 생성자, 초기화 =============================================================================================
	public Users(String id, String pw, String userType, String email, ArrayList<Book> bB, ArrayList<Book> rB) {
		this.id = id;
		this.pw = pw;
		this.name = "unknown";
		this.userType = userType;
		this.email = email;
		borrowedBook = bB;
		borrowedCount = borrowedBook.size();	// 현재 대출한 도서 수
		reservedBook = rB;
		reservedCount = reservedBook.size();	// 현재 예약된 도서 수
		overdueBook = null;
		setOverdueBook();
	}
	public Users() {
		id = null;
		pw = null;
		email = null;
		name = "unknown";
		userType = "unknown";
	}


	// 기타 메소드 ===============================================================================================
	public static String numToUserType(int i) {
		if (i == 1) return "Manager";
		else if (i == 2) return "Librarian";
		else return null;
	}

	public boolean isOverdue() {	// 연체상태 반환
		if(overdueCount != 0) return true;
		else return false;
	}
	public boolean availableToBorrow() {	// 대출 가능여부 확인
		if(borrowedCount < MAX_borrowedCount && !isOverdue()) return true;
		else return false;
	}
	public boolean availableToReserve() {	// 대출 가능여부 확인 
		if(reservedCount < MAX_reservedCount) return true;
		else return false;
	}
	
	//연체 체크
	public boolean OverdueCheck(String d) {
		Date date = null;
		Date today = null;
		Calendar now = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String nowTime = formatter.format(now.getTime());
		try {
			date = formatter.parse(d);
			today = formatter.parse(nowTime);			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (today.after(date)) {
			return true;
		}
		return false;
	}
	
	// getter, setter
	public String getName() 					{return name;}				// 이름 반환 
	public String getId() 						{return id;}				// id 반환
	public String getPw()						{return pw;}				// pw 반환
	public String getUserType()					{return userType;}			// userType 반환
	public String getEmail()					{return email;}
	public int getBorrowedCount() 					{return borrowedCount;}		// 대출한 도서 수 반환 
	public int getReservedCount() 				{return reservedCount;}		// 예약한 도서 수 반환
	public ArrayList<Book> getBorrowedBook()	{return borrowedBook;}		// 대출한 도서 반환
	public ArrayList<Book> getReservedBook()	{return reservedBook;}		// 예약한 도서 반환
	public ArrayList<Book> getOverdueBook()	{return overdueBook;}		// 연체된 도서 반환

	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setBorrowedBook(ArrayList<Book> borrowedBook) {
		this.borrowedBook = borrowedBook;
		this.borrowedCount = borrowedBook.size();
		if(borrowedCount != 0) {
			setOverdueBook();			
		}
	}
	public void setReservedBook(ArrayList<Book> reservedBook) {
		this.reservedBook = reservedBook;
		this.reservedCount = reservedBook.size();
	}
	
	public void setOverdueBook() {
		int cnt =0;
		for (int i=0; i<borrowedCount; i++) {
			String d = borrowedBook.get(i).getIbs().getReturnDate();
			if(d == null) {
				return;
			}
			if(OverdueCheck(d)) {
				overdueBook = new ArrayList<Book>();
				overdueBook.add(borrowedBook.get(i));
				cnt++;
			}
		}
		overdueCount = cnt; 
	}
	public int getMAX_borrowedCount() {
		return MAX_borrowedCount;
	}
	public void setMAX_borrowedCount(int mAX_borrowedCount) {
		MAX_borrowedCount = mAX_borrowedCount;
	}
	public int getMAX_reservedCount() {
		return MAX_reservedCount;
	}
	public void setMAX_reservedCount(int mAX_reservedCount) {
		MAX_reservedCount = mAX_reservedCount;
	}
	public int getOverdueCount() {
		return overdueCount;
	}
	public void setOverdueCount(int overdueCount) {
		this.overdueCount = overdueCount;
	}
	public void setOverdueBook(ArrayList<Book> overdueBook) {
		this.overdueBook = overdueBook;
	}
}
