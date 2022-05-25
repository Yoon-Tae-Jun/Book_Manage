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
		setMinimumSize(new Dimension(width, height));		// 창 최대 크기
		setMaximumSize(new Dimension(width, height));		// 창 최소 크기
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
		panel.setSize(new Dimension(width, height));							// 패널 크기 설정
		panel.setLocation((pWidth/2 - width/2), (pHeight/2 - height/2)-17);		// 패널 위치 설정
		panel.setBackground(new Color(93, 93, 93));								// 패널 배경색 설정
		panel.setLayout(new BorderLayout(3 ,3));								// 패널 레이아웃 설정
		panel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(93, 93, 93)));	// 패널 테두리 설정
		
		// add()
		panel.add(north_box(), BorderLayout.NORTH);
		panel.add(west_box_library(), BorderLayout.WEST);
		panel.add(cb_borrowAndReturn(), BorderLayout.CENTER);
		
		return panel;
	}
	// north_box ---------------------------------------------------------------------------------------------------------
	private JPanel north_box() {
		int width = 900;
		int height = 60;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.WHITE);											// 패널 배경 설정
		panel.setBorder(BorderFactory.createEmptyBorder(13, 20, 13, 13));	// 패널 여백 설정
		panel.setLayout(new BorderLayout());
		
		// add()
		panel.add(north_left_box(), BorderLayout.WEST);
		panel.add(north_right_box(), BorderLayout.EAST);
		
		return panel;
	}
	private JPanel north_left_box() {
		int width = 801;
		int height = 60;
		
		JButton btn = new JButton(libraryName);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);											// 패널 배경 설정
		panel.setLayout(new GridLayout(1, 5, 10, 0));
		
		// add()
		panel.add(btn);
		panel.add(EmptyPanel());
		panel.add(EmptyPanel());
		panel.add(EmptyPanel());
		panel.add(EmptyPanel());
		
		return panel;
	}
	private JPanel north_right_box() {
		int width = 60;
		int height = 60;
		
		JButton btn = new JButton("내 계정");
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);											// 패널 배경 설정
		panel.setLayout(new GridLayout(1, 1));
		
		// add()
		panel.add(btn);
				
		return panel;
	}
	// west_box ----------------------------------------------------------------------------------------------------------
	private JPanel west_box_library() {
		int width = 150;
		int height = 460;
		
		JButton btn1 = new JButton("1. 대출, 반납");
		JButton btn2 = new JButton("2. 도서 관련");
		JButton btn3 = new JButton("3. 사용자 관련");
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.WHITE);											// 패널 배경 설정
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	// 패널 여백 설정
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 8));
		
		// add()
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		return panel;
	}
	private JPanel west_box_user() {
		int width = 150;
		int height = 460;
		
		JButton btn1 = new JButton("1. 사용자 관련 기능");
		JButton btn2 = new JButton("2. 사용자 관련 기능");
		JButton btn3 = new JButton("3. 사용자 관련 기능");
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.WHITE);											// 패널 배경 설정
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	// 패널 여백 설정
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 8));
		
		// add()
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		return panel;
	}
	// center_box --------------------------------------------------------------------------------------------------------
	private JPanel center_box() {
		int width = 750;
		int height = 460;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.WHITE);									// 패널 배경 설정
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	// 패널 여백 설정
		
		// add()
		
		return panel;
	}
	// center_box : 대출, 반납 ---------------------------------------------------------------------------------------------
	private JPanel cb_borrowAndReturn() {
		int width = 750;
		int height = 460;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.YELLOW);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		
		// add()
		panel.add(EmptyPanel(), BorderLayout.WEST);
		panel.add(cb_borrowAndReturn_right_box(), BorderLayout.EAST);
		
		return panel;
	}
	private JPanel cb_borrowAndReturn_right_box() {
		int width = 300;
		int height = 460;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.GREEN);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		
		// add()
		panel.add(cb_bookInfos2(), BorderLayout.NORTH);
		panel.add(cb_userInfos2(), BorderLayout.CENTER);
		panel.add(cb_modifyButtons(), BorderLayout.SOUTH);
		
		return panel;
	}
	// center_box : 도서 관련 ----------------------------------------------------------------------------------------------
	private JPanel cb_books() {
		int width = 750;
		int height = 460;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.YELLOW);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		
		// add()
		panel.add(cb_searchBooks(), BorderLayout.WEST);
		panel.add(cb_books_right_box(), BorderLayout.EAST);
		
		return panel;
	}
	private JPanel cb_books_right_box() {
		int width = 300;
		int height = 460;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.GREEN);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		
		// add()
		panel.add(cb_bookInfos(), BorderLayout.CENTER);
		panel.add(cb_modifyButtons(), BorderLayout.SOUTH);
		
		return panel;
	}
	// center_box : 사용자 관련 ---------------------------------------------------------------------------------------------
	private JPanel cb_users() {
		int width = 750;
		int height = 460;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.YELLOW);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		
		// add()
		panel.add(cb_searchUsers(), BorderLayout.WEST);
		panel.add(cb_users_right_box(), BorderLayout.EAST);
		
		return panel;
	}
	private JPanel cb_users_right_box() {
		int width = 300;
		int height = 460;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.GREEN);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		
		// add()
		panel.add(cb_userInfos(), BorderLayout.CENTER);
		panel.add(cb_modifyButtons(), BorderLayout.SOUTH);
		
		return panel;
	}
	// center_box : 여러 패널들 ---------------------------------------------------------------------------------------------
	private JPanel cb_modifyButtons() {
		int width = 300;
		int height = 60;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.ORANGE);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		
		return panel;
	}
	private JPanel cb_bookInfos() {
		int width = 300;
		int height = 400;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.PINK);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		
		return panel;
	}
	private JPanel cb_bookInfos2() {
		int width = 300;
		int height = 200;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.DARK_GRAY);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		
		return panel;
	}
	private JPanel cb_userInfos() {
		int width = 300;
		int height = 400;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.PINK);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		
		return panel;
	}
	private JPanel cb_userInfos2() {
		int width = 300;
		int height = 200;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.MAGENTA);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		
		return panel;
	}
	private JPanel cb_searchBooks() {
		int width = 450;
		int height = 460;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.BLUE);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		
		return panel;
	}
	private JPanel cb_searchUsers() {
		int width = 450;
		int height = 460;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.RED);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		
		return panel;
	}
	
	// EmptyPanel --------------------------------------------------------------------------------------------------------
	private JPanel EmptyPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(null);
		return panel;
	}
}
