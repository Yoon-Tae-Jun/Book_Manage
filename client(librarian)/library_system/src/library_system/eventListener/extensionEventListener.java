package library_system.eventListener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import API.APIMethod;
import library_books.Book;
import library_system.layout.GuiLibraryDesk;
import library_users.Users;

public class extensionEventListener extends MouseAdapter{

	private GuiLibraryDesk desk;
	public extensionEventListener(GuiLibraryDesk desk)
	{
		this.desk = desk;
	}
	public void mousePressed(MouseEvent e) {
		Users user = desk.getPatron();
		Book book = desk.getBookSelected();
		if(book == null) {
			desk.la_borrowAndReserve.setText("책을 선택해 주세요.");
			desk.la_borrowAndReserve.setForeground(Color.RED);
			return;
		}
		if(user.getId().equals(book.getIbs().getBorrowedUser())) {
			
			if(!user.OverdueCheck(book.getIbs().getBorrowedDate())) {
				if(book.getIbs().getExternDateCount() == 0) {
					desk.la_borrowAndReserve.setText("연장 횟수를 초과했습니다.");
					desk.la_borrowAndReserve.setForeground(Color.RED);
					return;
				}
				else {
					int bookid = Integer.parseInt(desk.getBookSelected().getIb().getId());
					int externcnt = book.getIbs().getExternDateCount();
					APIMethod.postExtensioncount(bookid, externcnt -1);
					desk.la_borrowAndReserve.setText("연장 성공");
					desk.la_borrowAndReserve.setForeground(Color.BLACK);
					desk.setBookSelected(APIMethod.getBookData(bookid));
				}
			}
			else {
				desk.la_borrowAndReserve.setText("사용자가 연체 상태입니다.");
				desk.la_borrowAndReserve.setForeground(Color.RED);
				return;
			}
		}
		else {
			desk.la_borrowAndReserve.setText("사용자가 대출한 책이 아닙니다.");
			desk.la_borrowAndReserve.setForeground(Color.RED);
			return;
		}
	}
}
