package library_system;

import library_system.eventListener.ChangeCenterBox;
import library_system.eventListener.GoToMain;
import library_system.eventListener.GoToMain2;
import library_system.eventListener.Login_EventListener;
import library_system.layout.GuiLibraryDesk;
import library_system.layout.GuiLoginPage;

public class Render {
	private GuiLibraryDesk desk;
	private GuiLoginPage login;
	
	public Render() {
		login = new GuiLoginPage("SCH Library");
		Login();
		if(!(desk == null))
			Change_screen();
	}
	
	
	public void Login() {
		login.getLogin_Button().addActionListener(new Login_EventListener(this));
	}

	public void Change_screen() {
		desk.btn_libraryName.addMouseListener(new GoToMain(desk));
		desk.btn_myAccount.addMouseListener(new GoToMain2(desk));
		desk.btn_1.addMouseListener(new ChangeCenterBox(desk));
		desk.btn_2.addMouseListener(new ChangeCenterBox(desk));
		desk.btn_3.addMouseListener(new ChangeCenterBox(desk));
	}
	//getter, setter
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
