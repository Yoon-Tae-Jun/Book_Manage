package library_system.eventListener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import library_system.layout.GuiLibraryDesk;

public class modifyUserEventListener extends MouseAdapter{
	private GuiLibraryDesk desk;
	private String id;
	private String name;
	private String email;
	private String password;
	
	public modifyUserEventListener(GuiLibraryDesk desk)
	{
		this.desk = desk;

	}
	
	public void mousePressed(MouseEvent e) {
		int statuscode;
		if(desk.getSelect_screen() == 4) {
			id = desk.tf_book_4_info[0].getText();
			name =desk.tf_book_4_info[1].getText();
			email= desk.tf_book_4_info[3].getText();
			password = desk.tf_book_4_info[4].getText();
			String[] data = {id, name, email, password};
			//저장
			if(desk.getBtn_save_sel()) {
				desk.setBtn_save_sel(false);
			}
			
			//변경
			else {
				desk.setBtn_save_sel(true);
				desk.tf_book_4_info[0].setEnabled(true);
				desk.tf_book_4_info[1].setEnabled(true);
				desk.tf_book_4_info[3].setEnabled(true);
				desk.tf_book_4_info[4].setEnabled(true);
				
				desk.btn_save.setText("저장");
				desk.btn_cancel_add_save.setVisible(true);
				desk.la_bookSearch.setText("수정할 정보를 입력하세요.");
				desk.la_bookSearch.setForeground(Color.BLUE);
			}
		}
			
		}
}
