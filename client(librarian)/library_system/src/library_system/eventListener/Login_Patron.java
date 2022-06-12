package library_system.eventListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import org.json.simple.JSONObject;

import API.Call_API;
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
		
		//API 통신 관련 변수
		Call_API api = new API.Call_API();
		JSONObject obj;
		
		//파라메터 정보
		HashMap<String, String> option = new HashMap<String, String>();
		option.put("userEmail", ld.tf_login_mini_id.getText());
		option.put("password", ld.tf_login_mini_pw.getText());
		
		// API Method를 이용하여 사용자 로그인
		// 로그인 성공하면 성공한 사용자 정보를 user에 형식으로 저장
		ld.setPatron(null);
		// 로그인 실패시 null 저장, 실패 문구 출
		ld.setPatron(null);
		ld.la_loginText.setText("사용자 정보를 다시 확인해 주세요.");
		
		ld.btn1_enabled_loggedin(); 	// 로그인 후 상태로 버튼 enabled 설정
	}// end of actionPerformed()
}
