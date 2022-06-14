package library_system.eventListener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import API.APIMethod;
import library_system.layout.GuiLibraryDesk;

public class reservedEventListener extends MouseAdapter{
	private GuiLibraryDesk desk;
	public reservedEventListener(GuiLibraryDesk desk)
	{
		this.desk = desk;
	}
	
	public void mousePressed(MouseEvent e) {
		int statuscode;
		int bookid = Integer.parseInt(desk.getBookSelected().getIb().getId());
		int userid = Integer.parseInt(desk.getPatron().getId());
		statuscode = APIMethod.postReservedBook(bookid,userid );
		if(statuscode == 200) {
			desk.la_borrowAndReserve.setText("예약 성공");
			desk.la_borrowAndReserve.setForeground(Color.BLACK);
			desk.setBookSelected(APIMethod.getBookData(bookid));
		}
		else {
			desk.la_borrowAndReserve.setText("예약 실패");
			desk.la_borrowAndReserve.setForeground(Color.RED);
		}

	}
}
