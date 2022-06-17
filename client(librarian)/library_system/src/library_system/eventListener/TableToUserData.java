package library_system.eventListener;

import library_system.layout.GuiLibraryDesk;
import library_users.*;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;


public class TableToUserData extends MouseAdapter{
	private GuiLibraryDesk ld;
	public TableToUserData(GuiLibraryDesk ld) {
		this.ld = ld;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// 테이블 데이터 얻어오기
		JTable tb = (JTable)e.getSource(); 
		int row = tb.getSelectedRow();
		
		// 선택된 사용자 저장
		ld.setUserSelected(ld.getUsers()[row]);
		
		// 선택된 사용자 출력
		Users user = (Users)ld.getUserSelected();
		user.setOverdueBook();
		// {"이름 :", "타입 :", "아이디 :", "비밀번호 :"};
		if(ld.getSelect_screen() == 4) {
			
			
			if(ld.getUserSelected().getBorrowedCount() != 0) {
				int size = ld.getUserSelected().getBorrowedCount();
				
				for(int i=0; i<size; i++) {
					ld.cb_book_info_5_size[0][i] =  (ld.getUserSelected().getBorrowedBook().get(i)).getIb().getName();		
				}
			}
			if(ld.getUserSelected().getReservedCount() != 0) {
				int size = ld.getUserSelected().getReservedCount();
				
				for(int i=0; i<size; i++) {
					ld.cb_book_info_5_size[1][i] =  (ld.getUserSelected().getReservedBook().get(i)).getIb().getName();		
				}
			}
			if(ld.getUserSelected().getOverdueCount() != 0) {
				int size = ld.getUserSelected().getOverdueCount();
				
				for(int i=0; i<size; i++) {
					ld.cb_book_info_5_size[2][i] =  (ld.getUserSelected().getOverdueBook().get(i)).getIb().getName();		
				}
			}
			JButton btn = ld.btn_1;
			JPanel panel = (JPanel)btn.getParent().getParent();
			BorderLayout lb = (BorderLayout)panel.getLayout();
			panel.remove(lb.getLayoutComponent(BorderLayout.CENTER));
			panel.add(ld.cb_users(),BorderLayout.CENTER);
			panel.revalidate();
			panel.repaint();
			ld.tf_book_4_info[0].setText(user.getId());			// 아이디 
			ld.tf_book_4_info[1].setText(user.getName());		// 이름
			ld.tf_book_4_info[2].setText(user.getUserType());	// 타입
			ld.tf_book_4_info[3].setText(user.getEmail());	// 타입
			ld.tf_book_4_info[4].setText(user.getPw());			// 비밀번호
			ld.table_1.addMouseListener(new TableToBookData(ld));
		}
		
	}
}