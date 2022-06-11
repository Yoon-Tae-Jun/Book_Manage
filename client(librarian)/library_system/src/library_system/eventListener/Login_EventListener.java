package library_system.eventListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


import org.json.simple.JSONObject;

import API.*;
import library_system.LibraryDesk;
import library_system.Render;
import library_system.layout.GuiLibraryDesk;
import library_system.layout.GuiLoginPage;
import library_users.Users;

public class Login_EventListener implements ActionListener {
	
	private Render render;
	private GuiLoginPage login_page;
	private GuiLibraryDesk libraryDesk;
	
	public Login_EventListener(Render render)
	{
		this.render = render;
		this.login_page = this.render.getLogin();
		this.libraryDesk = this.render.getDesk();
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		Users user = new Users();
		
		//API 통신 관련 변수
		Call_API api = new API.Call_API();
		JSONObject obj;
		
		//파라메터 정보
		HashMap<String, String> option = new HashMap<String, String>();
		option.put("userEmail", login_page.getEmail_Text().getText());
		option.put("password", login_page.getPassword_Text().getText());
		
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
				libraryDesk = new GuiLibraryDesk(user, login_page.getLibraryName());
				ld.run();
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
