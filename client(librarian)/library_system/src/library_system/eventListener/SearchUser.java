package library_system.eventListener;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import API.APIMethod;
import library_books.Book;
import library_system.layout.GuiLibraryDesk;
import library_users.Users;

public class SearchUser extends MouseAdapter{
	private GuiLibraryDesk desk;
	private String checkedButtonName;
	private String SearchingWord_user;	
	private Users[] users;
	
	public SearchUser(GuiLibraryDesk desk) {
		this.desk = desk;
		this.users = desk.getUsers();
	}
	
	public void mousePressed(MouseEvent e) {
		SearchingWord_user = desk.tf_search_user.getText();		
		checkedButtonName = desk.group_2.getSelection().getActionCommand();
		Users[] users = null;
		
		Book[] books = null;
		// users = "생성된 Users[] 저장"
		switch(checkedButtonName) {
		case "이름":
			users =APIMethod.getUsersData(SearchingWord_user, 0);
			break;
		case "타입":
			users =APIMethod.getUsersData(SearchingWord_user, 1);
			break;
		case "아이디":
			users =APIMethod.getUsersData(SearchingWord_user, 2);
			break;
		case "대출도서":
			books = APIMethod.getBooksData(SearchingWord_user, 0);
			users = new Users[books.length];
			for(int i=0; i< books.length; i++) {
				users[i] = APIMethod.getUserDataID(books[i].getIbs().getBorrowedUser());
			}
			break;
		case "예약도서":
			books = APIMethod.getBooksData(SearchingWord_user, 0);
			users = new Users[books.length];
			for(int i=0; i< books.length; i++) {
				users[i] = APIMethod.getUserDataID(books[i].getIbs().getReservedUser());
			}
			break;
		}
		System.out.println();
		desk.setUsers(users);
		desk.updateJTableUsers();	// JTable 업데이트(users에 저장된 사용자들 JTable에 띄우기)
		
		// 화면에 다시 그리기
		JButton btn = desk.btn_1;
		JPanel panel = (JPanel)btn.getParent().getParent();
		BorderLayout l = (BorderLayout)panel.getLayout();
		panel.remove(l.getLayoutComponent(BorderLayout.CENTER));
		if(desk.getClickedButton().equals("1. 대출")) panel.add(desk.cb_borrow(), BorderLayout.CENTER);
		else if(desk.getClickedButton().equals("2. 반납")) panel.add(desk.cb_return(), BorderLayout.CENTER);
		else if(desk.getClickedButton().equals("3. 도서 관련")) panel.add(desk.cb_books(), BorderLayout.CENTER);
		else panel.add(desk.cb_users(), BorderLayout.CENTER);
		panel.revalidate();
		panel.repaint();
		desk.table_2.addMouseListener(new TableToUserData(desk));
		}
}


