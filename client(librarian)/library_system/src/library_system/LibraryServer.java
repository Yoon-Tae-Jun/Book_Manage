package library_system;
import library_users.*;
import library_books.*;

public class LibraryServer {
	
	// 전부 static 메소드로 만들기 **
	// 아래 형식에 맞게 작성해주면 서버 프로그래밍 해주면 됨
	// 궁금한건 시간 상관없이 바로바로 연락하기 !
	
	public static Users login(Users userInfo) {
		// 입력 : userInfo.id, userInfo.pw, userInfo.userType
		// 출력 : 해당 사용자 정보들 가진 User 클래스 (Librarian, Manager, Patron)
		
		// 입력에 해당되는 값들을 주면, 이에 맞는 사용자의 필드들을 불러와 Users 객체를 생성해 return 하면 됨.
		// 일치하는 사용자 없을시에 null 반환
		return new Users();
	}
	public static Book[] searchBooks(Book book) {
		// 입력 : book의 필드들
		// 출력 : 해당 필드와 일치하는 Book 배열
		
		// 입력으로 book 객체가 들어오면, book 객체안 필드값들과 일치하는 책들을 book[] 배열로 만들어 리턴
		// 일치하는 book의 필드와 일치하는 도서가 없으면 null값 반환
		return new Book[0];
	}
	public static Book getBooks(String id) {
		// 입력 : 책 고유 번호 (String id) 
		// 출력 : 해당 id의 책 객체
		
		// 입력으로 책 고유 번호 (String id)를 주면, 해당 id 값의 책 정보들을 불러와 book 객체로 만들어 리턴
		// 일치하는 고유번호가 없으면, null 리턴
		return new Book();
	}
}
