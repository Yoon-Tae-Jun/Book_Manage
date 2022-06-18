package library_system.eventListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.json.simple.JSONObject;

import API.APIMethod;
import library_system.Render;
import library_system.layout.GuiLibraryDesk;
import library_system.layout.GuiLoginPage;
import library_users.Users;

public class Login_Patron implements ActionListener {
	
	private GuiLibraryDesk ld;
	
	public Login_Patron(GuiLibraryDesk ld){
		this.ld = ld;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		Users user = new Users();
		user = APIMethod.getUserData(ld.tf_login_mini_id.getText(),ld.tf_login_mini_pw.getText());
		if(user.getId() != null) {
			user.setOverdueBook();
			ld.setPatron(user);
			if(ld.getSelect_screen() == 1) {
				ld.btn1_enabled_loggedin();	
			}
			else if(ld.getSelect_screen() == 2) {
				ld.btn2_enabled_loggedin();	
				
				ld.setBooks(APIMethod.getBorrowedBook(Integer.parseInt(user.getId())));
				ld.updateJTableBooks();	// JTable 업데이트(books에 저장된 도서들 JTable에 띄우기)
				JButton btn = ld.btn_1;
				JPanel panel = (JPanel)btn.getParent().getParent();
				BorderLayout lb = (BorderLayout)panel.getLayout();
				panel.remove(lb.getLayoutComponent(BorderLayout.CENTER));
				if(ld.getClickedButton().equals("1. 대출")) panel.add(ld.cb_borrow(), BorderLayout.CENTER);
				else if(ld.getClickedButton().equals("2. 반납")) panel.add(ld.cb_return(), BorderLayout.CENTER);
				else if(ld.getClickedButton().equals("3. 도서 관련")) panel.add(ld.cb_books(), BorderLayout.CENTER);
				else panel.add(ld.cb_users(), BorderLayout.CENTER);
				panel.revalidate();
				panel.repaint();
				ld.table_1.addMouseListener(new TableToBookData(ld));
					
			
			}
		}
		else {
			ld.la_loginText.setText("사용자 정보를 다시 확인해 주세요.");
			ld.la_loginText.setForeground(Color.RED);
		}
		
		
		 	// 로그인 후 상태로 버튼 enabled 설정
	}// end of actionPerformed()
}