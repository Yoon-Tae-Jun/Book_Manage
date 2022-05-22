package library_books;

public class Book {
	
	InfoBook ib;			// 책의 기본 정보
	InfoBookStatement ibs;	// 책의 현황 정보
	
	// 생성자, 초기화 =============================================================================================
	public Book(InfoBook ib, InfoBookStatement ibs) {
		// 기존 책 불러올때 사용
		this.ib = ib;
		this.ibs = ibs;
	}
	public Book() {
		// 비어있는 도서(새로운 도서) 생성
		this.ib = new InfoBook();
		this.ibs = new InfoBookStatement();
	}
	
	// 책 정보 출력 ==============================================================================================
	public void printInfo() {	// 책 전체 정보 출력
		printInfoBook();
		printInfoBookStatemet();
	}
	public void printInfoBook() {
		System.out.println("== 도서 정보 ============================");
		System.out.println("제목 : " + ib.getName() + ", 책 번호 : " + ib.getId());
		System.out.println("저자 : " + ib.getAuthor());
		System.out.println("장르 : " + ib.getGenre());
		System.out.println("출판 년도 : " + ib.getYear());
		System.out.println("책 도서관 반입일 : " +ib.getAddedDate());
	}
	public void printInfoBookStatemet() {
		System.out.println("== 도서 상태 ============================");
		System.out.println("현재 대출자 : " + ibs.getBorrowedUser());
		System.out.println("현재 예약자 : " + ibs.getReservedUser());
		System.out.println("대출일 : " + ibs.getBorrowedDate());
		System.out.println("반납일 : " + ibs.getReturnDate() + ", 연장 횟수(" +ibs.getExternDateCount()+ ")");
	}
	
	// 책 정보 수정 ==============================================================================================
	public void updateInfoBook() {
		System.out.println("== 도서 정보 수정 ============================");
		System.out.println("1. 제목");
		System.out.println("2. 저자");
		System.out.println("3. 장르");
		System.out.println("4. 출판 년도");
		// 도서 정보 수정
		// ***
		printInfo();
	}
}