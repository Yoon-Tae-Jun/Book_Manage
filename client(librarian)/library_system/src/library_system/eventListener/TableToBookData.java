package library_system.eventListener;

import library_system.layout.GuiLibraryDesk;
import library_books.*;
import java.awt.event.*;
import javax.swing.*;


public class TableToBookData extends MouseAdapter{
	private GuiLibraryDesk ld;
	public TableToBookData(GuiLibraryDesk ld) {
		this.ld = ld;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// 테이블 데이터 얻어오기
		JTable tb = (JTable)e.getSource(); 
		int row = tb.getSelectedRow();
		
		// 선택된 도서 저장
		ld.setBookSelected(ld.getBooks()[row]);
		
		// 선택된 도서 출력
		Book book = ld.getBookSelected();
		InfoBook ib = book.getIb();
		InfoBookStatement ibs = book.getIbs();
		
		// {"제목 :", "저자 :", "장르 :", "출판 년도 :", "책 번호 :"}
		ld.tf_book_2_info[0].setText(ib.getName());		// 제목
		ld.tf_book_2_info[1].setText(ib.getAuthor());	// 저자
		ld.tf_book_2_info[2].setText(ib.getGenre());	// 장르 
		ld.tf_book_2_info[3].setText(ib.getYear());		// 년도 
		ld.tf_book_2_info[4].setText(ib.getId());		// 책 고유번호
		
		// {"현재 대출자 :", "현재 예약자 :", "대출일 :", "반납입(연장횟수) :"}
		ld.tf_book_3_info[0].setText(ibs.getBorrowedUser());	// 현재 대출자 
		ld.tf_book_3_info[1].setText(ibs.getReservedUser());	// 현재 예약자
		ld.tf_book_3_info[2].setText(ibs.getBorrowedDate());	// 대출일 
		ld.tf_book_3_info[3].setText(ibs.getReturnDate());		// 반납입(연장횟수)
	}
}