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
		
		try {
			obj = api.POST("/login", option);
		
			int statusCode = Integer.parseInt(String.valueOf(obj.get("statusCode")));
			System.out.println(statusCode);
			if(statusCode == 200) {
				JSONObject data = (JSONObject) obj.get("data");
				user.setPw((String)data.get("password"));
				user.setId((String)data.get("userEmail"));
				user.setName((String)data.get("UserName"));
				user.setUserType((String)data.get("userType"));
				login_page.setVisible(false);
				render.setDesk(new GuiLibraryDesk(user, login_page.getLibraryName()));
				render.Change_screen();
			}
			else {
				System.out.println("login fail");
				login_page.getError_Text().setText("아이디나 비밀번호가 틀렸습니다.");
				login_page.getError_Text().setForeground(Color.RED);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
