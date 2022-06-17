package library_system.eventListener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import API.APIMethod;
import library_system.layout.GuiLibraryDesk;

public class deleteBookEventListener  extends MouseAdapter{
	private GuiLibraryDesk desk;
	public deleteBookEventListener(GuiLibraryDesk desk)
	{
		this.desk = desk;
	}
	
	public void mousePressed(MouseEvent e) {
		int statuscode;
		if(desk.getSelect_screen() == 3) {
			if (desk.getBookSelected() == null) {
				desk.la_bookSearch.setText("책을 선택해주세요.");
				desk.la_bookSearch.setForeground(Color.RED);
				return;
			}
			else {
				statuscode = APIMethod.deleteBook(Integer.parseInt(desk.getBookSelected().getIb().getId()));
				if(statuscode >= 200 && statuscode <= 300) {
					desk.la_bookSearch.setText("삭제 성공");
					desk.la_bookSearch.setForeground(Color.BLACK);				
				}
				else {
					desk.la_bookSearch.setText("삭제 실패");
					desk.la_bookSearch.setForeground(Color.RED);
					return;
				}
			}
		}
		else if (desk.getSelect_screen() == 4) {
			if (desk.getUserSelected() == null) {
				desk.la_userSearch.setText("사용자를 선택해주세요.");
				desk.la_userSearch.setForeground(Color.RED);
				return;
			}
			if(desk.getUserSelected().getBorrowedCount() != 3 ) {
				desk.la_userSearch.setText("사용자를 선택해주세요.");
				desk.la_userSearch.setForeground(Color.RED);
				return;
			}
			else {
				statuscode = APIMethod.deleteUser(Integer.parseInt(desk.getUserSelected().getId()));
				if(statuscode >= 200 && statuscode <= 300) {
					desk.la_userSearch.setText("삭제 성공");
					desk.la_userSearch.setForeground(Color.BLACK);				
				}
				else {
					desk.la_userSearch.setText("삭제 실패");
					desk.la_userSearch.setForeground(Color.RED);
					return;
				}
			}
		}
	}
	
}
