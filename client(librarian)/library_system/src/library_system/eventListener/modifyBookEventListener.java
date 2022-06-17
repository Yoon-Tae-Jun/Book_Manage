package library_system.eventListener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import API.APIMethod;
import library_system.layout.GuiLibraryDesk;

public class modifyBookEventListener extends MouseAdapter{
	private GuiLibraryDesk desk;
	private String name;
	private String author;
	private String genre;
	private String year;
	
	private String username;
	private String email;
	private String password;
	public modifyBookEventListener(GuiLibraryDesk desk)
	{
		this.desk = desk;

	}
	
	public void mousePressed(MouseEvent e) {
		int statuscode;
		if(desk.getSelect_screen() == 3) {
			name = desk.tf_book_2_info[0].getText();
			author =desk.tf_book_2_info[1].getText();
			genre = desk.tf_book_2_info[2].getText();
			year = desk.tf_book_2_info[3].getText();
			String[] data = {name, author, genre, year};
			//저장
			if(desk.getBtn_save_sel()) {
				for(int i=0; i<4; i++) {
					if (data[i].equals("")) {
						desk.la_bookSearch.setText("정보를 공백 없이 입력하세요.");
						desk.la_bookSearch.setForeground(Color.RED);
						return;
					}
					
					if(i > 1) {
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
				}
				
				statuscode = APIMethod.postUpdateBook(Integer.parseInt(desk.getBookSelected().getIb().getId()), name, author, genre, year);
				if(statuscode == 200) {
					desk.setBtn_save_sel(false);
					desk.tf_book_2_info[0].setEnabled(false);
					desk.tf_book_2_info[1].setEnabled(false);
					desk.tf_book_2_info[2].setEnabled(false);
					desk.tf_book_2_info[3].setEnabled(false);
					desk.la_bookSearch.setText("변경 완료");
					desk.la_bookSearch.setForeground(Color.BLACK);
					desk.btn_save.setText("변경");
					desk.btn_cancel_add_save.setVisible(false);
					return;
				}
				else {
					desk.la_bookSearch.setText("변경 실패");
					desk.la_bookSearch.setForeground(Color.BLACK);
				}
			}
			//변경
			else {		
				desk.setBtn_save_sel(true);
				desk.tf_book_2_info[0].setEnabled(true);
				desk.tf_book_2_info[1].setEnabled(true);
				desk.tf_book_2_info[2].setEnabled(true);
				desk.tf_book_2_info[3].setEnabled(true);
				desk.la_bookSearch.setText("수정할 정보를 입력하세요.");
				desk.la_bookSearch.setForeground(Color.BLUE);
				desk.btn_save.setText("저장");
				desk.btn_cancel_add_save.setVisible(true);
			}
		}
		else if (desk.getSelect_screen() == 4) {
			username =desk.tf_book_4_info[1].getText();
			email= desk.tf_book_4_info[3].getText();
			password = desk.tf_book_4_info[4].getText();
			String[] data = {username, email, password};
			//저장
			if(desk.getBtn_save_sel()) {
				for(int i=0; i<3; i++) {
					if (data[i].equals("")) {
						desk.la_userSearch.setText("정보를 공백 없이 입력하세요.");
						desk.la_userSearch.setForeground(Color.RED);
						return;
					}
					
					if(i == 1){
						if(data[i].contains("@") == false) {
							desk.la_userSearch.setText("유효한 이메일주소를 적어주세요");
							desk.la_userSearch.setForeground(Color.RED);
							return;
						}
					}
				}
				
				statuscode = APIMethod.postUpdateUser(Integer.parseInt(desk.getUserSelected().getId()), email, password, username);
				if(statuscode == 200) {
					desk.setBtn_save_sel(false);
					desk.tf_book_4_info[1].setEnabled(false);
					desk.tf_book_4_info[3].setEnabled(false);
					desk.tf_book_4_info[4].setEnabled(false);
					desk.la_userSearch.setText("변경 완료");
					desk.la_userSearch.setForeground(Color.BLACK);
					desk.btn_save.setText("변경");
					desk.btn_cancel_add_save.setVisible(false);
					return;
				}
				else {
					desk.la_userSearch.setText("변경 실패");
					desk.la_userSearch.setForeground(Color.BLACK);
				}
			}
			
			//변경
			else {
				desk.setBtn_save_sel(true);
				desk.tf_book_4_info[1].setEnabled(true);
				desk.tf_book_4_info[3].setEnabled(true);
				desk.tf_book_4_info[4].setEnabled(true);

				desk.la_userSearch.setText("수정할 정보를 입력하세요.");
				desk.la_userSearch.setForeground(Color.BLUE);
				desk.btn_save.setText("저장");
				desk.btn_cancel_add_save.setVisible(true);
			}
		}
		
	}
}
