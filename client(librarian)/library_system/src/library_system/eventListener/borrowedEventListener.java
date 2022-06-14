package library_system.eventListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import API.APIMethod;
import library_books.Book;
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
		int borrowedCnt = desk.getPatron().getMAX_borrowedCount();
		if (desk.getBookSelected() == null) {
			desk.la_borrowAndReserve.setText("책을 선택해주세요.");
			desk.la_borrowAndReserve.setForeground(Color.RED);
			return;
		}
		else if(borrowedCnt == 0) {
			desk.la_borrowAndReserve.setText("더 이상 빌릴 수 없습니다.");
			desk.la_borrowAndReserve.setForeground(Color.RED);
			return;
		}
		int bookid = Integer.parseInt(desk.getBookSelected().getIb().getId());
		int userid = Integer.parseInt(desk.getPatron().getId());
		statuscode = APIMethod.postBorrowedBook(bookid,userid);
		if(statuscode == 200) {
			desk.la_borrowAndReserve.setText("대출 성공");
			desk.la_borrowAndReserve.setForeground(Color.BLACK);
			desk.setBookSelected(APIMethod.getBookData(bookid));
			desk.getPatron().setMAX_borrowedCount(--borrowedCnt);
		}
		else {
			desk.la_borrowAndReserve.setText("대출 실패");
			desk.la_borrowAndReserve.setForeground(Color.RED);
		}

	}
}
