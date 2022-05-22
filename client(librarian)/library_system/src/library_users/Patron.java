package library_users;
import java.util.ArrayList;

// 도서관 이용자 : Patron
// 도서관 이용자 클래스
// @건아
public class Patron extends Users{
	
	private int borrowedCount;						// 대출한 도서 수
	private ArrayList<String> borrowedBook;			// 대출한 도서 목록 (도서 id(String))
	private int reservedCount;						// 예약한 도서 수
	private ArrayList<String> reservedBook;			// 예약된 도서 목록 (도서 id(String))
	private int overdueCount;						// 연체된 도서 수
	private ArrayList<String> overdueBook; 			// 연체된 도서 목록 (도서 id(String))
	
	public static final int MAX_borrowedCount = 5;		// 최대 대출 가능 갯수
	public static final int MAX_reservedCount = 3;		// 최대 예약 가능 갯수
	
	// 생성자, 초기화 =============================================================================================
	public Patron(String id, String pw, String name, ArrayList<String> bB, ArrayList<String> rB, ArrayList<String> oB) {
		// 기존 사용자 만들때(불러올때) 사용
		super(id, pw, name);
		borrowedBook = bB;
		borrowedCount = borrowedBook.size();	// 현재 대출한 도서 수
		reservedBook = rB;
		reservedCount = reservedBook.size();	// 현재 예약된 도서 수
		overdueBook = oB;
		overdueCount = overdueBook.size();		// 현재 연체된 도서 수
	}
	public Patron(String id, String pw, String name) {
		// 신규 사용자 만들때 사용
		this(id, pw, name, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
	}
	
	// 사용자 정보(상태) 가져오기 메소드 ==============================================================================
	public int getBorrowdNum() 					{return borrowedCount;}		// 대출한 도서 수 반환 
	public int getReservedNum() 				{return reservedCount;}		// 예약한 도서 수 반환
	public ArrayList<String> getBorrowedBook()	{return borrowedBook;}		// 대출한 도서 반환
	public ArrayList<String> getReservedBook()	{return reservedBook;}		// 예약한 도서 반환
	public ArrayList<String> getOverdueBook()	{return overdueBook;}		// 연체된 도서 반환
	
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
	
	// 사용자 정보 수정 메소드 ======================================================================================
	public void updateBorrowedBook(ArrayList<String> bB) {borrowedBook = bB;}	// 대출한 도서 목록 교체 
	public void updateReservedBook(ArrayList<String> rB) {reservedBook = rB;}	// 예약된 도서 목록 교체 
	public void updateOverdueBook(ArrayList<String> oB) {overdueBook = oB;}		// 연체된 도서 목록 교체 
}
