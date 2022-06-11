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
	public void mousePressed(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		JPanel panel = (JPanel)btn.getParent().getParent();
		BorderLayout l = (BorderLayout)panel.getLayout();
		panel.remove(l.getLayoutComponent(BorderLayout.CENTER));
		
		if(btn.getText().equals("1. 대출, 반납")) {
			panel.add(ld.cb_borrowAndReturn(), BorderLayout.CENTER);
			panel.revalidate();
			panel.repaint();
		}
		else if(btn.getText().equals("2. 도서 관련")) {
			panel.add(ld.cb_books(), BorderLayout.CENTER);
			panel.revalidate();
			panel.repaint();
		}
		else if(btn.getText().equals("3. 사용자 관련")) {
			panel.add(ld.cb_users(), BorderLayout.CENTER);
			panel.revalidate();
			panel.repaint();
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
