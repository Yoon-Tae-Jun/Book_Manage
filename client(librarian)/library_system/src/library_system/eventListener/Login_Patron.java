package library_system.eventListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import org.json.simple.JSONObject;

import API.APIMethod;
import library_system.Render;
import library_system.layout.GuiLibraryDesk;
import library_system.layout.GuiLoginPage;
import library_users.Users;

public class Login_Patron implements ActionListener {
	
	private GuiLibraryDesk ld;
	
	public Login_Patron(GuiLibraryDesk ld){
		this.ld = ld;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		Users user = new Users();
		user = APIMethod.getUserData(ld.tf_login_mini_id.getText(),ld.tf_login_mini_pw.getText());
		System.out.println(user.getName());
		if(user.getId() != null) {
			ld.setPatron(user);
		}
		else {
			ld.la_loginText.setText("사용자 정보를 다시 확인해 주세요.");
		}
		
		
		ld.btn1_enabled_loggedin(); 	// 로그인 후 상태로 버튼 enabled 설정
	}// end of actionPerformed()
}