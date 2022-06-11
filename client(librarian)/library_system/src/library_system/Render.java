package library_system;

import library_system.eventListener.Login_EventListener;
import library_system.layout.GuiLibraryDesk;
import library_system.layout.GuiLoginPage;

public class Render {
	private GuiLibraryDesk desk;
	private GuiLoginPage login;
	
	public Render() {
		login = new GuiLoginPage("SCH Library");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public void Login() {
		login.getLogin_Button().addActionListener(new Login_EventListener(this));
	}

	public GuiLibraryDesk getDesk() {
		return desk;
	}

	public void setDesk(GuiLibraryDesk desk) {
		this.desk = desk;
	}

	public GuiLoginPage getLogin() {
		return login;
	}

	public void setLogin(GuiLoginPage login) {
		this.login = login;
	}
	
}
