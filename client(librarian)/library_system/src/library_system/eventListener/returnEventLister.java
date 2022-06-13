package library_system.eventListener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import API.APIMethod;
import library_system.layout.GuiLibraryDesk;

public class returnEventLister extends MouseAdapter{
	private GuiLibraryDesk desk;
	public returnEventLister(GuiLibraryDesk desk)
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
		int day = calDate(desk.getBookSelected().getIbs().getReturnDate());
		if(day < 0) {
			day = 0;
		}
		statuscode = APIMethod.postReturnBook(bookid,userid,day);
		if(statuscode == 200) {
			desk.la_borrowAndReserve.setText("취소 성공");
			desk.la_borrowAndReserve.setForeground(Color.BLACK);
			desk.setBookSelected(APIMethod.getBookData(bookid));
		}
		else {
			desk.la_borrowAndReserve.setText("취소 실패");
			desk.la_borrowAndReserve.setForeground(Color.RED);
		}

	}
	
	public int calDate(String rd) {
		Calendar getToday = Calendar.getInstance();
		getToday.setTime(new Date()); //금일 날짜
		int diffDays = 0;
		
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rd);
			Calendar cmpDate = Calendar.getInstance();
			cmpDate.setTime(date); //특정 일자
			
			long diffSec = (getToday.getTimeInMillis() - cmpDate.getTimeInMillis()) / 1000;
			diffDays = (int)(diffSec / (24*60*60)); //일자수 차이
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return diffDays;
	}
}
