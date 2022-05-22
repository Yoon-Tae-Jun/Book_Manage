package library_system;
import library_users.*;
import java.awt.*;
import javax.swing.*;

import java.util.*;

// 로그인 페이지
public class Library {
	String libraryName; // 도서관 이름
	
	// 로그인 필드
	String id;			// 아이디
	String pw;			// 비밀번호 
	String userType;	// 관리자 or 사서
	Users userLogin;	// 로그인 객체
	
	public Library(String libraryName) {
		this.libraryName = libraryName;
	}
	
	// 도서관 프로그램 실행 (순서)
	public void run() {
		
		// 1. 로그인 -- GUI
		new GuiLoginPage(libraryName);	// 로그인 페이지 실행
				
				// 바로 아래 소스코드들은 이벤트 처리로 바꾸기
				userLogin = new Users(id, pw, userType);			// 입력받은 정보들로 User 객체 생성
				userLogin = LibraryServer.login(userLogin);			// 로그인
			
				if(userLogin == null || userLogin.getUserType().equals("Patron")) {		// 로그인 실패시 다시 정보 입력
					System.out.println("일치하는 사용자 정보가 없습니다. 다시 시도해주세요.");
				}
		
		// 2. 로그인 성공 후, 도서관리 프로그램(LibraryDesk) 실행
		LibraryDesk ld = new LibraryDesk(userLogin, libraryName);
		ld.run();
	}
	
}

