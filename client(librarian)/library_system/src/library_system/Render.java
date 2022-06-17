package library_system;

import javax.swing.JButton;
import javax.swing.JRadioButton;

import API.APIMethod;
import library_system.eventListener.*;
import library_system.layout.GuiLibraryDesk;
import library_system.layout.GuiLoginPage;

public class Render {
	private GuiLibraryDesk desk;
	private GuiLoginPage login ;
	
	public Render() {
		login = new GuiLoginPage("SCH Library");
		Login();
		//desk = new GuiLibraryDesk(null, "ss");
		//Change_screen();
		//APIMethod.getBooksData("2022", 3);
	}
	
	
	public void Login() {
		login.getLogin_Button().addActionListener(new Login_EventListener(this));
	}

	public void Change_screen() {
		// 창 전환
		desk.btn_libraryName.addMouseListener(new GoToMain(desk));
		desk.btn_myAccount.addMouseListener(new GoToMain2(desk));
		// CenterBox 창 전환
		desk.btn_1.addMouseListener(new ChangeCenterBox(desk));
		desk.btn_2.addMouseListener(new ChangeCenterBox(desk));
		desk.btn_3.addMouseListener(new ChangeCenterBox(desk));
		desk.btn_4.addMouseListener(new ChangeCenterBox(desk));
		// 책, 사용자 검색
		desk.btn_search.addMouseListener(new SearchBook(desk));
		desk.btn_search_user.addMouseListener(new SearchUser(desk));
		// JTable 데이터 띄우기
		desk.table_1.addMouseListener(new TableToBookData(desk));
		desk.table_2.addMouseListener(new TableToUserData(desk));
		// 도서관 이용자 로그인, 로그아웃
		desk.btn_login.addActionListener(new Login_Patron(desk));
		desk.btn_logout.addActionListener(new Logout_Patron(desk));
		// 대출, 반납, 예약
		desk.btn_image.addMouseListener(new imagePopEventListener(desk));
		desk.btn_borrow.addMouseListener(new borrowedEventListener(desk));
		desk.btn_reserve.addMouseListener(new reservedEventListener(desk));
		desk.btn_cancel_reserve.addMouseListener(new cancelReservedEventListener(desk));
		desk.btn_return.addMouseListener(new returnEventLister(desk));
		desk.btn_cancel_borrow.addMouseListener(new extensionEventListener(desk));
		
		desk.btn_del.addMouseListener(new deleteBookEventListener(desk));
		desk.btn_save.addMouseListener(new modifyBookEventListener(desk));
		desk.btn_add.addMouseListener(new putBookEventListener(desk));
		
	}
	
	//getter, setter
	public GuiLibraryDesk getDesk() {
		return desk;
	}

	public void setDesk(GuiLibraryDesk desk) {
		this.desk = desk;
	}

	public GuiLoginPage getLogin() {
		return login;
	}

	public void setLogin(GuiLoginPage login) {
		this.login = login;
	}
	
}