package library_system.eventListener;

import library_system.layout.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChangeCenterBox extends MouseAdapter {
	private GuiLibraryDesk ld;
	public ChangeCenterBox(GuiLibraryDesk ld) {
		this.ld = ld;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		Container panel = btn.getParent().getParent();
		
		if(btn.getText().equals("1. 대출, 반납")) {
			panel.add(ld.cb_borrowAndReturn(), BorderLayout.CENTER);
		}
		else if(btn.getText().equals("2. 도서 관련")) {
			panel.add(ld.cb_books(), BorderLayout.CENTER);
		}
		else if(btn.getText().equals("3. 사용자 관련")) {
			panel.add(ld.cb_users(), BorderLayout.CENTER);
		}
		else {
			panel.add(ld.center_box(), BorderLayout.CENTER);
		}
	}
}
