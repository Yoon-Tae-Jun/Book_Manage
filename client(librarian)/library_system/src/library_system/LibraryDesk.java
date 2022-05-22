package library_system;
import library_users.*;		// 사용자 관련 클래스들
import library_books.*;		// 책 관련 클래스들

// 도서관리 프로그램 페이지
public class LibraryDesk{

	String libraryName; // 도서관 이름
	Users user;		// 로그인 된 사용자 (Librarian, Manager)
	Book book;		// 조회할 책
	Patron patron;	// 조회할 사용자 (Patron)
	
	
	// 생성자, 초기화 =============================================================================================
	public LibraryDesk(Users user, String libraryName) {
		this.user = user;
		this.libraryName = libraryName;
	}
	
	// 업무 시작 =================================================================================================
	public void run() {
		// 1. 프로그램 실행 -- GUI
		new GuiLibraryDesk(libraryName);
	}
	
	// 도서 관련 업무 1 ===========================================================================================
		public void findBook() {
			// 도서 조회 - 사서, 관리자
		}
		public void borrowBook() {
			// 도서 대출 - 사서, 관리자
		}
		public void returnBook() {
			// 도서 반납 - 사서, 관리자
		}
		public void reserveBook() {
			// 도서 예약 - 사서, 관리자
		}
		public void cancelBorrowBook() {
			// 도서 대출 취소 - 사서, 관리자
		}
		public void cancelReturnBook() {
			// 도서 반납 취소 - 사서, 관리자
		}
		public void cancelReserveBook() {
			// 도서 예약 취소 - 사서, 관리자
		}
	// 도서 관련 업무 2 ===========================================================================================
		public void modifyBook() {
			// 도서 정보 변경 - 관리자
			// 책 고유번호, 책이 도서관에 추가된 날짜
			// 책 이름, 저자, 장르, 출판년도, 이미지
			if(user.getUserType().equals("Librarian")) {
				System.out.println("사서 계정으로 실행할 수 없는 기능입니다.");
				return;
			}
		}
		public void updateBookStatement() {
			// 도서 상태 정보 변경 - 사서, 관리자
			// 대출자, 예약자, 대출일, 반납일(연장횟)
		}
		public void addNewBook() {
			// 새로운 도서 추가 - 관리자
			if(user.getUserType().equals("Librarian")) {
				System.out.println("사서 계정으로 실행할 수 없는 기능입니다.");
				return;
			}
		}
		public void deleteBook() {
			// 책 제거 - 관리자
			if(user.getUserType().equals("Librarian")) {
				System.out.println("사서 계정으로 실행할 수 없는 기능입니다.");
				return;
			}
		}
		
	// 사용자 관리 업무 1 ==========================================================================================
		public void isPossibleToBorrow() {
			// 대출 가능 여부 확인 - 사서, 관리자
		}
		public void checkReturnDate() {
			// 연체 여부 확인 - 사서, 관리자
		}
		public void checkReserved() {
			// 예약 여부 확인 - 사서, 관리자
		}
	// 사용자 관리 업무 2 ==========================================================================================
		public void updateUserInfo() {
			// 사용자 정보 수정 - 사서, 관리자
		}
		public void addNewUser() {
			// 신규 사용자 생성 - 사서, 관리자
			// 사서, 관리, 이용자(Patron) 생성 (관리자는 관리자만 생성 가능)
		}
}
