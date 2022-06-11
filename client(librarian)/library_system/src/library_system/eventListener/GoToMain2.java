package library_system.eventListener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import library_system.layout.*;

public class GoToMain2 extends MouseAdapter  {
	private GuiLibraryDesk ld;
	public GoToMain2(GuiLibraryDesk ld) {
		this.ld = ld;
	}
	public void mouseClicked(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		JPanel panel = (JPanel)btn.getParent().getParent().getParent();
		BorderLayout l = (BorderLayout)panel.getLayout();
		
		panel.remove(l.getLayoutComponent(BorderLayout.CENTER));
		panel.remove(l.getLayoutComponent(BorderLayout.WEST));
		
		panel.add(ld.center_box(), BorderLayout.CENTER);
		panel.add(ld.west_box_user(), BorderLayout.WEST);
		
		panel.revalidate();
		panel.repaint();
	}
}
