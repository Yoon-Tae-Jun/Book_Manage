package library_system.eventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import library_system.layout.GuiLibraryDesk;

public class Logout_Patron implements ActionListener{
	
	private GuiLibraryDesk ld;		// GuiLibraryDesk
	
	public Logout_Patron(GuiLibraryDesk ld){
		this.ld = ld;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ld.setPatron(null);		// 로그인 된 사용자 정보 삭제
		if(ld.getSelect_screen() == 1) {
			ld.btn1_enabled(); 		// 로그인 전 상태로 버튼 enabled 설정
		}
		else if (ld.getSelect_screen() == 2) {
			ld.btn2_enabled(); 
		}
		
	}
	
	
}