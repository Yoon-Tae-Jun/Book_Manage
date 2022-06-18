package library_system.eventListener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import API.APIMethod;
import library_system.layout.GuiLibraryDesk;

public class putBookEventListener extends MouseAdapter{
	private GuiLibraryDesk desk;
	private String name;
	private String author;
	private String genre;
	private String year;
	private String url;
	
	private String username;
	private String type;
	private String email;
	private String password;
	public putBookEventListener(GuiLibraryDesk desk)
	{
		this.desk = desk;
	}
	
	public void mousePressed(MouseEvent e) {
		
		//저장
		if(desk.getSelect_screen() == 3) {
			int statuscode;
			name = desk.tf_book_2_info[0].getText();
			author =desk.tf_book_2_info[1].getText();
			genre = desk.tf_book_2_info[2].getText();
			year = desk.tf_book_2_info[3].getText();
			url = desk.tf_book_2_info[4].getText();
			String[] data = {name, author, genre, year,url};
			if(desk.getBtn_add_sel()) {
				for(int i=0; i<5; i++) {
					if (data[i].equals("")) {
						desk.la_bookSearch.setText("정보를 공백 없이 입력하세요.");
						desk.la_bookSearch.setForeground(Color.RED);
						return;
					}
					
					if(i > 1 && i < 4) {
						char tmp;
						for(int j = 0 ; j <data[i].length(); j++) {
							tmp = data[i].charAt(j);	
							
							if(Character.isDigit(tmp) == false) {	//문자열이 숫자가 아닐 경우
								desk.la_bookSearch.setText("장르, 년도는 숫자만 입력하세요.");
								desk.la_bookSearch.setForeground(Color.RED);
								return;
							}
						}
					}
					
					if(i==4) {
						if((url.contains("http://") || url.contains("https://")) == false) {
							desk.la_bookSearch.setText("올바른 주소를 입력하세요.");
							desk.la_bookSearch.setForeground(Color.RED);
							return;
						}
						
					}
				}
				
				statuscode = APIMethod.putBook(name, author, genre, year,url);
				if(statuscode == 200) {
					desk.setBtn_add_sel(false);
					desk.tf_book_2_info[0].setEnabled(false);
					desk.tf_book_2_info[1].setEnabled(false);
					desk.tf_book_2_info[2].setEnabled(false);
					desk.tf_book_2_info[3].setEnabled(false);
					desk.tf_book_2_info[4].setEnabled(false);
					desk.la_book_2_info[4].setText("책 번호");
					desk.la_bookSearch.setText("추가 완료");
					desk.la_bookSearch.setForeground(Color.BLACK);
					desk.btn_add.setForeground(Color.BLACK);
					desk.btn_cancel_add_save.setVisible(false);
					return;
				}
				else {
					desk.la_bookSearch.setText("변경 실패");
					desk.la_bookSearch.setForeground(Color.RED);
				}
			}
			//변경
			else {		
				desk.setBtn_add_sel(true);
				desk.tf_book_2_info[0].setEnabled(true);
				desk.tf_book_2_info[1].setEnabled(true);
				desk.tf_book_2_info[2].setEnabled(true);
				desk.tf_book_2_info[3].setEnabled(true);
				desk.tf_book_2_info[4].setEnabled(true);
				desk.la_book_2_info[4].setText("URL");
				desk.la_bookSearch.setText("추가할 정보를 입력하세요.");
				desk.la_bookSearch.setForeground(Color.BLUE);
				desk.btn_cancel_add_save.setVisible(true);
				desk.btn_cancel_add_save.addMouseListener(new btn_cancel(desk));
				desk.btn_add.setForeground(Color.BLUE);
			}
		}
		else if(desk.getSelect_screen() == 4) {
			int statuscode;
			username =desk.tf_book_4_info[1].getText();
			type = desk.tf_book_4_info[2].getText();
			email = desk.tf_book_4_info[3].getText();
			password = desk.tf_book_4_info[4].getText();
			String[] data = {username, type, email, password};
			if(desk.getBtn_add_sel()) {
				for(int i=0; i<4; i++) {
					if (data[i].equals("")) {
						desk.la_userSearch.setText("정보를 공백 없이 입력하세요.");
						desk.la_userSearch.setForeground(Color.RED);
						return;
					}
					
					if(i == 1) {
						if((type.equals("ptn") || type.equals("lbn") || type.equals("mgr")) == false) {
							desk.la_userSearch.setText("유저 타입이 올바르지 않습니다.");
							desk.la_userSearch.setForeground(Color.RED);
							return;
						}
					}
					if(i == 2){
						if(data[i].contains("@") == false) {
							desk.la_userSearch.setText("유효한 이메일주소를 적어주세요");
							desk.la_userSearch.setForeground(Color.RED);
							return;
						}
					}
				}
				statuscode = APIMethod.putUser(username, email, password, type);
				if(statuscode == 200) {
					desk.setBtn_add_sel(false);
					desk.tf_book_4_info[1].setEnabled(false);
					desk.tf_book_4_info[2].setEnabled(false);
					desk.tf_book_4_info[3].setEnabled(false);
					desk.tf_book_4_info[4].setEnabled(false);
					desk.la_userSearch.setText("추가 완료");
					desk.la_userSearch.setForeground(Color.BLACK);
					desk.btn_add.setForeground(Color.BLACK);
					desk.btn_cancel_add_save.setVisible(false);
					return;
				}
				else if(statuscode == 503) {
					desk.la_userSearch.setText("이미 이메일이 존재합니다.");
					desk.la_bookSearch.setForeground(Color.RED);
				}
				else {
					desk.la_userSearch.setText("변경 실패");
					desk.la_bookSearch.setForeground(Color.RED);
				}
			}
			//변경
			else {		
				desk.setBtn_add_sel(true);
				desk.tf_book_4_info[1].setEnabled(true);
				desk.tf_book_4_info[2].setEnabled(true);
				desk.tf_book_4_info[3].setEnabled(true);
				desk.tf_book_4_info[4].setEnabled(true);
				desk.la_userSearch.setText("추가할 정보를 입력하세요.");
				desk.la_userSearch.setForeground(Color.BLUE);
				desk.btn_cancel_add_save.setVisible(true);
				desk.btn_cancel_add_save.addMouseListener(new btn_cancel(desk));
				desk.btn_add.setForeground(Color.BLUE);
			}
		}
			
		

	}
}
