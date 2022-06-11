package library_system;

import javax.swing.JRadioButton;

import API.APIMethod;
import library_system.eventListener.ChangeCenterBox;
import library_system.eventListener.GoToMain;
import library_system.eventListener.GoToMain2;
import library_system.eventListener.Login_EventListener;
import library_system.eventListener.TableToBookData;
import library_system.eventListener.TableToUserData;
import library_system.eventListener.main1SearchListener;
import library_system.layout.GuiLibraryDesk;
import library_system.layout.GuiLoginPage;

public class Render {
	private GuiLibraryDesk desk;
	private GuiLoginPage login ;
	
	public Render() {
		//login = new GuiLoginPage("SCH Library");
		//Login();
		desk = new GuiLibraryDesk(null, "ss");
		Change_screen();
		APIMethod.getBooksData("2022", 3);
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
		desk.table_1.addMouseListener(new TableToBookData(desk));
		desk.table_2.addMouseListener(new TableToUserData(desk));

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
