package library_system.eventListener;

import library_system.layout.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChangeCenterBox extends MouseAdapter {
	JButton btn1 = new JButton("1. 대출, 반납");
	JButton btn2 = new JButton("2. 도서 관련");
	JButton btn3 = new JButton("3. 사용자 관련");
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		Container panel = btn.getParent().getParent();
		
		if(btn.getText().equals("1. 대출, 반납")) {
			panel.add(GuiLibraryDesk.cb_borrowAndReturn(), BorderLayout.CENTER);
		}
		else if(btn.getText().equals("2. 도서 관련")) {
			panel.add(GuiLibraryDesk.cb_books(), BorderLayout.CENTER);
		}
		else if(btn.getText().equals("3. 사용자 관련")) {
			panel.add(GuiLibraryDesk.cb_users(), BorderLayout.CENTER);
		}
		else {
			panel.add(GuiLibraryDesk.center_box(), BorderLayout.CENTER);
		}
	}
}
