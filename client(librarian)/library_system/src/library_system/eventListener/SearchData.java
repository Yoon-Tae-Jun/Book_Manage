package library_system.eventListener;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import library_system.layout.GuiLibraryDesk;
import library_books.*;
import library_users.*;
import API.APIMethod;
// 체크된 라디오 버튼 이름으로 검색을 책과 사용자로 나누고
// 검색 결과에 따라, 책 정보, 사용자 정보를 불러와 배열로 만들고 반환하기
public class SearchData extends MouseAdapter{
	private GuiLibraryDesk desk;
	private String checkedButtonName;	// 체크된 라디오 버튼 이름
	private String SearchingWord_book;			// 검색어 : 책
	private String SearchingWord_user;			// 검색어 : 사용자
	private Book[] books;			// 검색결과(리턴) : 책
	private Users[] users;			// 검색결과(리턴) : 사용자
	
	public SearchData(GuiLibraryDesk desk) {
		this.desk = desk;
		this.books = desk.getBooks();
		this.users = desk.getUsers();
	}
	
	public void mousePressed(MouseEvent e) {
		SearchingWord_book = desk.tf_search.getText();			// 검색 키워드 TextField로 부터 받아오기 : 책
		SearchingWord_user = desk.tf_search_user.getText();		// 검색 키워드 TextField로 부터 받아오기 : 사용자
		checkedButtonName = desk.group_1.getSelection().getActionCommand();	// 체크된 라디오 버튼 이름 구하기
		
		// 체크박스로 도서검색 사용자검색 구분
		String[] rb_name = desk.radio_name_1;	// 라디오 버튼 이름 불러오기
		boolean is_book = false;
		for(String name : rb_name) if(checkedButtonName.equals(name)) is_book = true;	// 라디오 버튼(책) 이름과 동일한 것이 있는지 확인
		
		if(is_book) {
			// API 검색 : 검색어(SearchingWord_book)와 라디오버튼이름(checkedButtonName)으로 서버에서 검색하여 books에 저장
			int check =0;
			switch(checkedButtonName) {
				case "저자":
					check = 1;
				case "장르":
					check = 2;
				case "출판년도":
					check = 3;
				case "책 번호":
					check = 4;
			}
			desk.setBooks(APIMethod.getBooksData(SearchingWord_book,check));
			
			// books = "생성된 book[] 저장"
			//System.out.println(books.length);
			desk.updateJTableBooks();	// JTable 업데이트(books에 저장된 도서들 JTable에 띄우기)
			
			// 화면에 다시 그리기
			JButton btn = desk.btn_1;
			JPanel panel = (JPanel)btn.getParent().getParent();
			BorderLayout l = (BorderLayout)panel.getLayout();
			panel.remove(l.getLayoutComponent(BorderLayout.CENTER));
			panel.add(desk.cb_borrow(), BorderLayout.CENTER);
			panel.revalidate();
			panel.repaint();
		}
		else {
			// API 검색 : 검색어(SearchingWord_user)와 라디오버튼이름(checkedButtonName)으로 서버에서 검색하여 users에 저장
			Users[] users = null;
			
			Book[] books = null;
			// users = "생성된 Users[] 저장"
			switch(checkedButtonName) {
			case "이름":
				users =APIMethod.getUsersData(SearchingWord_book, 0);
			case "타입":
				users =APIMethod.getUsersData(SearchingWord_book, 1);
			case "아이디":
				users =APIMethod.getUsersData(SearchingWord_book, 2);
			case "대출도서":
				books = APIMethod.getBooksData(SearchingWord_book, 0);
				users = new Users[books.length];
				for(int i=0; i< books.length; i++) {
					users[i] = APIMethod.getUserDataID(books[i].getIbs().getBorrowedUser());
				}
			case "예약도서":
				books = APIMethod.getBooksData(SearchingWord_book, 0);
				users = new Users[books.length];
				for(int i=0; i< books.length; i++) {
					users[i] = APIMethod.getUserDataID(books[i].getIbs().getReservedUser());
				}
			}
			desk.setUsers(users);
			desk.updateJTableUsers();	// JTable 업데이트(users에 저장된 사용자들 JTable에 띄우기)
			
			// 화면에 다시 그리기
			JButton btn = desk.btn_1;
			JPanel panel = (JPanel)btn.getParent().getParent();
			BorderLayout l = (BorderLayout)panel.getLayout();
			panel.remove(l.getLayoutComponent(BorderLayout.CENTER));
			panel.add(desk.cb_return(), BorderLayout.CENTER);
			panel.revalidate();
			panel.repaint();
			}

		
		}

}