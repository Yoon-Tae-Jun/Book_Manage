package library_system.eventListener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import library_system.layout.*;

public class GoToMain extends MouseAdapter  {
	private GuiLibraryDesk ld;
	public GoToMain(GuiLibraryDesk ld) {
		this.ld = ld;
	}
	public void mouseClicked(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		JPanel panel = (JPanel)btn.getParent().getParent().getParent();
		
		panel.removeAll();
		panel.add(ld.north_box(), BorderLayout.NORTH);
		panel.add(ld.west_box_library(), BorderLayout.WEST);
		panel.add(ld.center_box(), BorderLayout.CENTER);
		panel.revalidate();
		panel.repaint();
	}
}