package library_system.eventListener;

import library_system.layout.*;
import library_users.Users;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import API.APIMethod;

public class ChangeCenterBox extends MouseAdapter {
	private GuiLibraryDesk ld;
	public ChangeCenterBox(GuiLibraryDesk ld) {
		this.ld = ld;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		JPanel panel = (JPanel)btn.getParent().getParent();
		BorderLayout l = (BorderLayout)panel.getLayout();
		panel.remove(l.getLayoutComponent(BorderLayout.CENTER));
		ld.setClickedButton(btn.getText()); // 클릭된 버튼 이름 저장
		
		if(btn.getText().equals("1. 대출")) {
			panel.add(ld.cb_borrow(), BorderLayout.CENTER);
			ld.btn1_enabled();
			panel.revalidate();
			panel.repaint();
			ld.setSelect_screen(1);
		}
		else if(btn.getText().equals("2. 반납")) {
			panel.add(ld.cb_return(), BorderLayout.CENTER);
			ld.btn2_enabled();
			panel.revalidate();
			panel.repaint();
			ld.setSelect_screen(2);
		}
	
		else if(btn.getText().equals("3. 도서 관련")) {
			panel.add(ld.cb_books(), BorderLayout.CENTER);
			ld.btn3_enabled();
			panel.revalidate();
			panel.repaint();
			ld.btn_cancel_add_save.addMouseListener(new btn_cancel(ld));
			ld.setSelect_screen(3);
		}
		else if(btn.getText().equals("4. 사용자 관련")) {
			panel.add(ld.cb_users(), BorderLayout.CENTER);
			ld.btn4_enabled();
			panel.revalidate();
			panel.repaint();
			ld.setSelect_screen(4);
		}
		else {
			panel.remove(l.getLayoutComponent(BorderLayout.WEST));
			panel.add(ld.center_box(), BorderLayout.CENTER);
			panel.add(ld.west_box_library(), BorderLayout.WEST);
			panel.revalidate();
			panel.repaint();
		}
	}
}