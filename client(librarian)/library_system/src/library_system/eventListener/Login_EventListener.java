package library_system.eventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Login_EventListener implements ActionListener {
	
	private JTextField email;
	private JTextField password;
	
	public Login_EventListener(JTextField email, JTextField password)
	{
		this.email = email;
		this.password = password;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton login_btn = (JButton)e.getSource();
		System.out.println(email.getText()+password.getText());
	}
	
}
