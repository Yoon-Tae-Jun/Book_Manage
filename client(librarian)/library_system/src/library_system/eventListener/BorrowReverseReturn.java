package library_system.eventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import library_system.layout.GuiLibraryDesk;

public class BorrowReverseReturn implements ActionListener {
	private GuiLibraryDesk ld;		// GuiLibraryDesk
	
	public BorrowReverseReturn(GuiLibraryDesk ld){
		this.ld = ld;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		String btnName = btn.getText();
		
		if(btnName.equals("대출")) {
			
		}
		else if(btnName.equals("예약")) {
			
		}
		else if(btnName.equals("반납")) {
			
		}
		else if(btnName.equals("대출취소")) {
			
		}
		else if(btnName.equals("예약취소")) {
			
		}
		else if(btnName.equals("반납취소")) {
			
		}
		else {
			
		}
	}
}