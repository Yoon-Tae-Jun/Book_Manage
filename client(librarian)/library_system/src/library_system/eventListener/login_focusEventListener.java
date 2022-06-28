package library_system.eventListener;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

import library_system.Render;
import library_system.layout.GuiLoginPage;

public class login_focusEventListener extends FocusAdapter {
	private JTextField field;
	private String hint;
	public login_focusEventListener(JTextField j, String hint)
	{
		field = j;
		this.hint = hint;
	}
	
	@Override
	public void focusLost(FocusEvent e) {	// 포커스를 잃었을 때,
		if (field.getText().equals("")) {
			field.setText(hint);
			field.setForeground(Color.GRAY);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {	// 포커스를 얻었을 때,
		if (field.getText().equals(hint)) {
			field.setText("");
			field.setForeground(Color.BLACK);
		}
	}
}
