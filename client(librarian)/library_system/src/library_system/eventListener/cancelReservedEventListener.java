package library_system.eventListener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import API.APIMethod;
import library_system.layout.GuiLibraryDesk;

public class cancelReservedEventListener extends MouseAdapter{
	private GuiLibraryDesk desk;
	public cancelReservedEventListener(GuiLibraryDesk desk)
	{
		this.desk = desk;
	}
	public void mousePressed(MouseEvent e) {
		int statuscode;
		if (desk.getBookSelected() == null) {
			desk.la_borrowAndReserve.setText("책을 선택해주세요.");
			desk.la_borrowAndReserve.setForeground(Color.RED);
			return;
		}
		int bookid = Integer.parseInt(desk.getBookSelected().getIb().getId());
		int userid = Integer.parseInt(desk.getUserSelected().getId());
		statuscode = APIMethod.postcancelReservedBook(bookid,userid );
		if(statuscode == 200) {
			desk.la_borrowAndReserve.setText("취소 성공");
			desk.la_borrowAndReserve.setForeground(Color.BLACK);
		}
		else {
			desk.la_borrowAndReserve.setText("취소 실패");
			desk.la_borrowAndReserve.setForeground(Color.RED);
		}

	}
}
