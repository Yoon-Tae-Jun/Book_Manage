package library_system.eventListener;

import library_system.layout.GuiLibraryDesk;
import library_users.*;
import java.awt.event.*;
import javax.swing.*;


public class TableToUserData extends MouseAdapter{
	private GuiLibraryDesk ld;
	public TableToUserData(GuiLibraryDesk ld) {
		this.ld = ld;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// 테이블 데이터 얻어오기
		JTable tb = (JTable)e.getSource(); 
		int row = tb.getSelectedRow();
		
		// 선택된 사용자 저장
		ld.setUserSelected(ld.getUsers()[row]);
		
		// 선택된 사용자 출력
		Patron user = (Patron)ld.getUserSelected();
		
		// {"이름 :", "타입 :", "아이디 :", "비밀번호 :"};
		ld.tf_book_4_info[0].setText(user.getName());		// 이름
		ld.tf_book_4_info[1].setText(user.getUserType());	// 타입
		ld.tf_book_4_info[2].setText(user.getId());			// 아이디 
		ld.tf_book_4_info[3].setText(user.getPw());			// 비밀번호
	}
}