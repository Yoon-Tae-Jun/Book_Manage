package library_system.layout;
import java.awt.*;
import javax.swing.*;

public class GuiLibraryDesk extends JFrame{
	
	private String libraryName;
	private int width = 1000;
	private int height = 650;
	
	//컨포넌트
	
	// GUI test
	public static void main(String[] args) {
		new GuiLibraryDesk("cse Library");
	}
	
	// main ------------------------------------------------------------------------------------------------------------
	public GuiLibraryDesk(String libraryName) {
		this.libraryName = libraryName;
		
		// this
		setTitle(this.libraryName);							// 창 이름
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	// 창 닫기
		setSize(width, height);								// 창 크기
		setLocationRelativeTo(null); 						// 창 생성 위치 : 화면 가운데
		
		// add()
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(239, 237, 239));
		c.add(pos_center(width, height));
		
		setVisible(true);
	}
	
	// pos_center --------------------------------------------------------------------------------------------------------
	private JPanel pos_center(int pWidth, int pHeight) {
		int width = 900;
		int height = 520;
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(width, height));						// 패널 크기 설정
		panel.setLocation((pWidth/2 - width/2), (pHeight/2 - height/2));	// 패널 위치 설정
		panel.setBackground(new Color(255, 255, 255));						// 패널 배경색 설정
		panel.setLayout(new BorderLayout());								// 패널 레이아웃 설정
		panel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(93, 93, 93)));	// 패널 테두리 설정
		
		// add()
		panel.add(north_box_B(), BorderLayout.NORTH);
		panel.add(west_box_B(), BorderLayout.WEST);
		panel.add(center_box_B(), BorderLayout.CENTER);
		
		return panel;
	}
	// north_box ---------------------------------------------------------------------------------------------------------
	private JPanel north_box_B() {
		int width = 900;
		int height = 60;
		JPanel panel = new JPanel();
		//panel.setSize(new Dimension(width, height));						// 패널 너비 설정
		panel.setPreferredSize(new Dimension(width, height));				// 패널 너비 설정
		panel.setBackground(Color.YELLOW);											// 패널 배경 없애기
		panel.setLayout(null);
		panel.setLocation(0, 50);
		panel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(93, 93, 93)));	// 패널 테두리 설정
		
		// add()
		panel.add(north_box());
		
		return panel;
	}
	private JPanel north_box() {
		int width = 900;
		int height = 60;
		JButton btn1 = new JButton(libraryName);
		JButton btn2 = new JButton("사용자");
		JPanel panel = new JPanel();
		//panel.setSize(new Dimension(width, height));						// 패널 너비 설정
		panel.setPreferredSize(new Dimension(width, height));				// 패널 너비 설정
		panel.setBackground(Color.PINK);											// 패널 배경 없애기
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	// 패널 여백 설정
		panel.setLayout(new GridLayout(1, 5));
		
		// add()
		panel.add(btn1);
		panel.add(EmptyPanel());
		panel.add(EmptyPanel());
		panel.add(EmptyPanel());
		panel.add(btn2);
		
		return panel;
	}
	// west_box ----------------------------------------------------------------------------------------------------------
	private JPanel west_box_B() {
		int width = 120;
		int height = 460;
		JPanel panel = new JPanel();
		//panel.setSize(new Dimension(width, height));						// 패널 크기 설정
		panel.setPreferredSize(new Dimension(width, height));				// 패널 너비 설정
		panel.setBackground(Color.BLUE);											// 패널 배경 없애기
		panel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(93, 93, 93)));	// 패널 테두리 설정
		
		// add()
		panel.add(EmptyPanel());
		
		return panel;
	}
	private JPanel west_box() {
		
	}
	// center_box --------------------------------------------------------------------------------------------------------
	private JPanel center_box_B() {
		int width = 780;
		int height = 460;
		JPanel panel = new JPanel();
		//panel.setSize(new Dimension(width, height));						// 패널 크기 설정
		panel.setPreferredSize(new Dimension(width, height));				// 패널 너비 설정
		panel.setBackground(Color.RED);											// 패널 배경 없애기
		panel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(93, 93, 93)));	// 패널 테두리 설정
		
		// add()
		panel.add(EmptyPanel());
		
		return panel;
	}
	private JPanel center_box() {
		
	}
	// EmptyPanel --------------------------------------------------------------------------------------------------------
	private JPanel EmptyPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(null);
		return panel;
	}
}
