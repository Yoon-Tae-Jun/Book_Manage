package library_system.layout;
import java.awt.*;
import javax.swing.*;

import library_system.eventListener.Login_EventListener;

public class GuiLoginPage extends JFrame {
	private String libraryName;
	private int width = 1000;
	private int height = 650;
	
	//컨포넌트
	private JButton login_Button = new JButton("로그인");
	private JTextField email_Text = new JTextField("전자메일 또는 휴대폰", 30);
	private JTextField password_Text = new JTextField("비밀번호", 20);
	private JLabel error_Text =new JLabel("어서오세요");
	
	//생성자
	public GuiLoginPage(String libraryName) {
		this.libraryName = libraryName;
		// this
		setTitle("도서관리시스템 - login");						// 창 제목 : 도서관리시스템 - login
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setSize(width, height);								// 창 전체 크기 설정
		setLocationRelativeTo(null); 						// 화면 가운데다 창 띄우기
		
		
		// add()
		Container c = getContentPane();
		c.setLayout(null);									// 배치관리자
		c.setBackground(new Color(239, 237, 239));
		c.add( CenterBox_B(width, height));				// 패널 추가
		setVisible(true);
	}
	
	private JPanel LeftBox_1() {

		JPanel LeftBox = new JPanel();
		LeftBox.setLayout(new GridLayout(1, 3));
		LeftBox.setBackground(null);
		LeftBox.add(new JLabel("cse 도서관"));
		LeftBox.add(EmptyPanel());
		LeftBox.add(EmptyPanel());	
		
		return LeftBox;
	}
	
	private JPanel LeftBox_2() {
		JPanel LeftBox = new JPanel();
		LeftBox.setLayout(new GridLayout(1, 2));
		LeftBox.setBackground(null);
		LeftBox.add(new JLabel("로그인"));
		LeftBox.add(EmptyPanel());
		
		return LeftBox;
	}
	
	private JPanel LeftBox_3() {
		JPanel LeftBox = new JPanel();
	
		LeftBox.setLayout(new GridLayout(1, 3));
		LeftBox.setBackground(null);
		LeftBox.add(EmptyPanel());
		LeftBox.add(EmptyPanel());
		LeftBox.add(login_Button);
		login_Button.addActionListener(new Login_EventListener(this ));
		return LeftBox;
	}
	
	private JPanel CenterBox() {
		JPanel CenterBox = new JPanel();
		CenterBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		CenterBox.setBackground(null);
		CenterBox.setLayout(new GridLayout(6, 1));
		
		// add
		CenterBox.add(LeftBox_1());
		CenterBox.add(LeftBox_2());
		CenterBox.add(error_Text);
		CenterBox.add(email_Text);
		CenterBox.add(password_Text);
		CenterBox.add(LeftBox_3());
		
		return CenterBox;
	}
	
	private JPanel CenterBox_B(int pWidth, int pHeight) {
		int width = 400;
		int height = 310;
		JPanel CenterBox = new JPanel();
		CenterBox.setSize(new Dimension(width, height));												// 패널 너비, 높이 설정
		CenterBox.setBackground(new Color(255, 255, 255));											// 패널 배경색 설정
		CenterBox.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, new Color(93, 93, 93)));		// 패널 border(top) 설정
		CenterBox.setLocation((pWidth/2 - width/2), (pHeight/2 - height/2));							// 패널 위치 설정
		CenterBox.setLayout(new GridLayout(1, 1));
		
		// add
		CenterBox.add(CenterBox());
		
		return CenterBox;
	}
	
	private JPanel EmptyPanel() {
		JPanel EmptyPanel = new JPanel();
		EmptyPanel.setBackground(null);
		return EmptyPanel;
	}

	
	public String getLibraryName() {
		return libraryName;
	}

	public JTextField getEmail_Text() {
		return email_Text;
	}

	public JTextField getPassword_Text() {
		return password_Text;
	}

	public JLabel getError_Text() {
		return error_Text;
	}



}




