package library_system.eventListener;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import API.APIMethod;
import library_system.Render;
import library_system.layout.GuiLibraryDesk;

public class borrowedEventListener extends MouseAdapter {
	
	private GuiLibraryDesk desk;
	public borrowedEventListener(GuiLibraryDesk desk)
	{
		this.desk = desk;
	}
	
	public void mousePressed(MouseEvent e) {
		int statuscode;
		int bookid = Integer.parseInt(desk.getBookSelected().getIb().getId());
		int userid = Integer.parseInt(desk.getUserSelected().getId());
		statuscode = APIMethod.postBorrowedBook(bookid,userid );
		if(statuscode == 200) {
			desk.la_borrowAndReserve.setText("대출 성공");
		}
		else {
			desk.la_borrowAndReserve.setText("대출 실패");
		}

	}
}
