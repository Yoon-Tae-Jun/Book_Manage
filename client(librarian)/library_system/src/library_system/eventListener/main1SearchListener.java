package library_system.eventListener;


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;

import API.APIMethod;
import library_books.Book;
import library_system.layout.GuiLibraryDesk;

public class main1SearchListener implements ItemListener {
	private GuiLibraryDesk desk;
	private ButtonGroup radioBtn;
	public main1SearchListener(GuiLibraryDesk desk) {
		this.desk = desk;
		this.radioBtn = desk.group_1;

	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getSource());
		//Book book = APIMethod.getBooksData(,column)
		
	}
}
