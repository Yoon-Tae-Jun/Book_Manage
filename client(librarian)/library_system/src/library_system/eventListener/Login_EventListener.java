package library_system.eventListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.json.simple.JSONObject;

import API.*;
import library_system.LibraryDesk;
import library_system.layout.GuiLibraryDesk;
import library_system.layout.GuiLoginPage;
import library_users.Users;

public class Login_EventListener implements ActionListener {
	

	private GuiLoginPage mine;
	public Login_EventListener(GuiLoginPage mine)
	{
		this.mine = mine;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		JButton login_btn = (JButton)e.getSource();
		Users user = new Users();
		
		//API 통신 관련 변수
		String url = "http://libraryserver-env.eba-yf973i6v.ap-northeast-2.elasticbeanstalk.com";
		Call_API api = new API.Call_API(url);
		JSONObject obj;
		
		//파라메터 정보
		HashMap<String, String> option = new HashMap<String, String>();
		option.put("userEmail", mine.getEmail_Text().getText());
		option.put("password", mine.getPassword_Text().getText());
		
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
				mine.setVisible(false);
				LibraryDesk ld = new LibraryDesk(user, mine.getLibraryName());
				ld.run();
			}
			else {
				System.out.println("login fail");
				mine.getError_Text().setText("아이디나 비밀번호가 틀렸습니다.");
				mine.getError_Text().setForeground(Color.RED);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	

	
}
