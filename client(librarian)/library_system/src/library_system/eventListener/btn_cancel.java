package library_system.eventListener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import library_system.layout.GuiLibraryDesk;

public class btn_cancel extends MouseAdapter{
	private GuiLibraryDesk desk;
	public btn_cancel(GuiLibraryDesk desk)
	{
		this.desk = desk;
	}
	
	public void mousePressed(MouseEvent e) {
		boolean add = desk.getBtn_add_sel();
		boolean save = desk.getBtn_save_sel();
		if(desk.getSelect_screen() == 3) {
			if(add) {
				desk.setBtn_add_sel(false);
				desk.tf_book_2_info[0].setEnabled(false);
				desk.tf_book_2_info[1].setEnabled(false);
				desk.tf_book_2_info[2].setEnabled(false);
				desk.tf_book_2_info[3].setEnabled(false);
				desk.tf_book_2_info[4].setEnabled(false);
				desk.la_book_2_info[4].setText("책 번호");
				desk.la_bookSearch.setText("취소됨");
				desk.la_bookSearch.setForeground(Color.BLACK);
				desk.btn_add.setForeground(Color.BLACK);
				desk.btn_cancel_add_save.setVisible(false);
				return;
			}
			else if (save) {
				desk.setBtn_save_sel(false);
				desk.tf_book_2_info[0].setEnabled(false);
				desk.tf_book_2_info[1].setEnabled(false);
				desk.tf_book_2_info[2].setEnabled(false);
				desk.tf_book_2_info[3].setEnabled(false);
				desk.la_bookSearch.setText("취소됨");
				desk.la_bookSearch.setForeground(Color.BLACK);
				desk.btn_save.setText("변경");
				desk.btn_cancel_add_save.setVisible(false);
			}
		}
		else if(desk.getSelect_screen() == 4) {
			if(add) {
				desk.setBtn_add_sel(false);
				desk.tf_book_4_info[1].setEnabled(false);
				desk.tf_book_4_info[2].setEnabled(false);
				desk.tf_book_4_info[3].setEnabled(false);
				desk.tf_book_4_info[4].setEnabled(false);
				desk.la_userSearch.setText("취소됨");
				desk.la_userSearch.setForeground(Color.BLACK);
				desk.btn_add.setForeground(Color.BLACK);
				desk.btn_cancel_add_save.setVisible(false);
				return;
			}
			else if (save) {
				desk.setBtn_save_sel(false);
				desk.tf_book_4_info[1].setEnabled(false);
				desk.tf_book_4_info[3].setEnabled(false);
				desk.tf_book_4_info[4].setEnabled(false);
				desk.la_userSearch.setText("취소됨");
				desk.la_userSearch.setForeground(Color.BLACK);
				desk.btn_save.setText("변경");
				desk.btn_cancel_add_save.setVisible(false);
			}
		}
	}
}
