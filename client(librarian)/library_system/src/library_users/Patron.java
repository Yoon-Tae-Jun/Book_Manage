package library_users;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import library_books.Book;

// 도서관 이용자 : Patron
// 도서관 이용자 클래스
// @건아
public class Patron extends Users{
	
	private int borrowedCount;						// 대출한 도서 수
	private ArrayList<Book> borrowedBook;			// 대출한 도서 목록 (도서 id(String))
	private int reservedCount;						// 예약한 도서 수
	private ArrayList<Book> reservedBook;			// 예약된 도서 목록 (도서 id(String))
	private int overdueCount;						// 연체된 도서 수
	private ArrayList<Book> overdueBook; 			// 연체된 도서 목록 (도서 id(String))
	private int MAX_borrowedCount;		// 최대 대출 가능 갯수
	private int MAX_reservedCount;		// 최대 예약 가능 갯수
	
	// 생성자, 초기화 =============================================================================================
	public Patron(String id, String pw, String name, ArrayList<Book> bB, ArrayList<Book> rB) {
		// 기존 사용자 만들때(불러올때) 사용
		super(id, pw, name);
		borrowedBook = bB;
		borrowedCount = borrowedBook.size();	// 현재 대출한 도서 수
		reservedBook = rB;
		reservedCount = reservedBook.size();	// 현재 예약된 도서 수
		overdueBook = null;		
		for (int i=0; i<borrowedCount; i++) {
			String d = borrowedBook.get(i).getIbs().getBorrowedDate();
			if(OverdueCheck(d)) {
				overdueBook.add(borrowedBook.get(i));
			}
		}

		overdueCount = overdueBook.size();		// 현재 연체된 도서 수
	}
	public Patron(String id, String pw, String name) {
		// 신규 사용자 만들때 사용
		this(id, pw, name, new ArrayList<Book>(), new ArrayList<Book>());
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
	private boolean OverdueCheck(String d) {
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
	public int getBorrowdNum() 					{return borrowedCount;}		// 대출한 도서 수 반환 
	public int getReservedNum() 				{return reservedCount;}		// 예약한 도서 수 반환
	public ArrayList<Book> getBorrowedBook()	{return borrowedBook;}		// 대출한 도서 반환
	public ArrayList<Book> getReservedBook()	{return reservedBook;}		// 예약한 도서 반환
	public ArrayList<Book> getOverdueBook()	{return overdueBook;}		// 연체된 도서 반환

	public void setBorrowedBook(ArrayList<Book> borrowedBook) {
		this.borrowedBook = borrowedBook;
	}
	public void setReservedBook(ArrayList<Book> reservedBook) {
		this.reservedBook = reservedBook;
	}
	public void setOverdueBook(ArrayList<Book> overdueBook) {
		this.overdueBook = overdueBook;
	}
}
