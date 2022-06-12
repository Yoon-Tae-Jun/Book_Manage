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
		user = APIMethod.getUserData(login_page.getEmail_Text().getText(),login_page.getPassword_Text().getText());
		
		if(user != null) {
			login_page.setVisible(false);
			render.setDesk(new GuiLibraryDesk(user, login_page.getLibraryName()));
			render.Change_screen();
		}
		else {
			login_page.getError_Text().setText("아이디나 비밀번호가 틀렸습니다.");
			login_page.getError_Text().setForeground(Color.RED);
		}
		
	}
	

	
}