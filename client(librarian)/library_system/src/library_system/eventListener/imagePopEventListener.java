package library_system.eventListener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import API.APIMethod;
import library_books.Book;
import library_system.layout.GuiLibraryDesk;
import library_system.layout.ImagePop;

public class imagePopEventListener extends MouseAdapter{
	private GuiLibraryDesk desk;
	public imagePopEventListener(GuiLibraryDesk desk)
	{
		this.desk = desk;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Book book = desk.getBookSelected();
		if (desk.getBookSelected() == null) {
			desk.la_borrowAndReserve.setText("책을 선택해주세요.");
			desk.la_borrowAndReserve.setForeground(Color.RED);
			return;
		}
		desk.la_borrowAndReserve.setText("");
		desk.la_borrowAndReserve.setForeground(Color.BLACK);
		int id = Integer.parseInt(book.getIb().getId());
		
		new ImagePop(id);

	}
}
