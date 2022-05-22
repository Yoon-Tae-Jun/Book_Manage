package library_system;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class GuiLoginPage extends JFrame {
	String libraryName;
	int width = 1000;
	int height = 650;
	
	GuiLoginPage_CenterBox_B centerB = new GuiLoginPage_CenterBox_B(width, height);
	
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
		c.add(centerB);				// 패널 추가
		setVisible(true);
	}
	// GUI test
	public static void main(String[] args) {
		new GuiLoginPage("cseLibrary");
	}

}
class GuiLoginPage_CenterBox_B extends JPanel {
	int width = 400;
	int height = 310;
	GuiLoginPage_CenterBox centerBox = new GuiLoginPage_CenterBox();
	
	public GuiLoginPage_CenterBox_B(int pWidth, int pHeight) {
		// this
		setSize(new Dimension(width, height));												// 패널 너비, 높이 설정
		setBackground(new Color(255, 255, 255));											// 패널 배경색 설정
		setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, new Color(93, 93, 93)));		// 패널 border(top) 설정
		setLocation((pWidth/2 - width/2), (pHeight/2 - height/2));							// 패널 위치 설정
		setLayout(new GridLayout(1, 1));
		
		// add
		add(centerBox);
	}
}
class GuiLoginPage_CenterBox extends JPanel{
	public GuiLoginPage_CenterBox() {
		
		// this
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		setBackground(null);
		setLayout(new GridLayout(6, 1));
		
		// add
		add(new GuiLoginPage_LeftBox_1());
		add(new GuiLoginPage_LeftBox_2());
		add(new JLabel("어서오세요"));
		add(new JTextField("전자메일 또는 휴대폰", 30));
		add(new JTextField("비밀번호", 20));
		add(new GuiLoginPage_LeftBox_3());
	}
}
class GuiLoginPage_LeftBox_1 extends JPanel{
	public GuiLoginPage_LeftBox_1() {
		setLayout(new GridLayout(1, 3));
		setBackground(null);
		add(new JLabel("cse 도서관"));
		add(new EmptyPanel());
		add(new EmptyPanel());
	}
}
class GuiLoginPage_LeftBox_2 extends JPanel{
	public GuiLoginPage_LeftBox_2() {
		setLayout(new GridLayout(1, 2));
		setBackground(null);
		add(new JLabel("로그인"));
		add(new EmptyPanel());
	}
}
class GuiLoginPage_LeftBox_3 extends JPanel{
	public GuiLoginPage_LeftBox_3() {
		setLayout(new GridLayout(1, 3));
		setBackground(null);
		add(new JLabel("로그인"));
		add(new EmptyPanel());
		add(new JButton("로그인"));
	}
}
class EmptyPanel extends JPanel{
	public EmptyPanel() {
		setBackground(null);
	}
}