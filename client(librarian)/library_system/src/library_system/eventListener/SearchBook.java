package library_system.eventListener;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import API.APIMethod;
import library_books.Book;
import library_system.layout.GuiLibraryDesk;

public class SearchBook extends MouseAdapter{
	private GuiLibraryDesk desk;
	private String checkedButtonName;
	private String SearchingWord_book;			// 검색어 : 책
	private Book[] books;	
	public SearchBook(GuiLibraryDesk desk) {
		this.desk = desk;
		this.books = desk.getBooks();
	}
	public void mousePressed(MouseEvent e) {
		SearchingWord_book = desk.tf_search.getText();
		checkedButtonName = desk.group_1.getSelection().getActionCommand();	// 체크된 라디오 버튼 이름 구하기
		int check =0;
		switch(checkedButtonName) {
			case "저자":
				check = 1;
				break;
			case "장르":
				check = 2;
				break;
			case "출판년도":
				check = 3;
				break;
			case "책 번호":
				check = 4;
				break;
		}
		desk.setBooks(APIMethod.getBooksData(SearchingWord_book,check));
		
		// books = "생성된 book[] 저장"
		//System.out.println(books.length);
		desk.updateJTableBooks();	// JTable 업데이트(books에 저장된 도서들 JTable에 띄우기)
		
		// 화면에 다시 그리기
		JButton btn = desk.btn_1;
		JPanel panel = (JPanel)btn.getParent().getParent();
		BorderLayout l = (BorderLayout)panel.getLayout();
		panel.remove(l.getLayoutComponent(BorderLayout.CENTER));
		if(desk.getClickedButton().equals("1. 대출")) panel.add(desk.cb_borrow(), BorderLayout.CENTER);
		else if(desk.getClickedButton().equals("2. 반납")) panel.add(desk.cb_return(), BorderLayout.CENTER);
		else if(desk.getClickedButton().equals("3. 도서 관련")) panel.add(desk.cb_books(), BorderLayout.CENTER);
		else panel.add(desk.cb_users(), BorderLayout.CENTER);
		panel.revalidate();
		panel.repaint();
		desk.table_1.addMouseListener(new TableToBookData(desk));
		}
}
