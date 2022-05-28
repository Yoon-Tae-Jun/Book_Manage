package library_system.layout;
import library_system.eventListener.*;
import java.awt.*;
import javax.swing.*;

public class GuiLibraryDesk extends JFrame{
	
	public static String libraryName;
	public static int width = 1000;
	public static int height = 650;
	
	//컨포넌트
	
	// GUI test
	public static void main(String[] args) {
		new GuiLibraryDesk("CSE Library");
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
	public static JPanel pos_center(int pWidth, int pHeight) {
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
		panel.add(west_box_library(), BorderLayout.WEST); // west_box_library(), west_box_user()
		panel.add(center_box(), BorderLayout.CENTER); // center_box(), cb_borrowAndReturn(), cb_books(), cb_users()
		
		return panel;
	}
	
	
	
	
	
	
	// north_box ---------------------------------------------------------------------------------------------------------
	public static JPanel north_box() {
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
	public static JPanel north_left_box() {
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
	public static JPanel north_right_box() {
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
	public static JPanel west_box_library() {
		int width = 150;
		int height = 460;
		
		JButton btn1 = new JButton("1. 대출, 반납");
		JButton btn2 = new JButton("2. 도서 관련");
		JButton btn3 = new JButton("3. 사용자 관련");
		btn1.addMouseListener(new ChangeCenterBox());
		btn2.addMouseListener(new ChangeCenterBox());
		btn3.addMouseListener(new ChangeCenterBox());
		
		
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
	public static JPanel west_box_user() {
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
	public static JPanel center_box() {
		int width = 741;
		int height = 451;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.WHITE);									// 패널 배경 설정
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	// 패널 여백 설정
		
		// add()
		
		return panel;
	}
	// center_box : 대출, 반납 ---------------------------------------------------------------------------------------------
	public static JPanel cb_borrowAndReturn() {
		int width = 741;
		int height = 451;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.WHITE);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		
		// add()
		panel.add(cb_searchBooks(), BorderLayout.WEST);
		panel.add(cb_borrowAndReturn_right_box(), BorderLayout.EAST);
		
		return panel;
	}
	public static JPanel cb_borrowAndReturn_right_box() {
		int width = 291;
		int height = 451;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, new Color(239, 237, 239)));	// 패널 테두리 설정
		
		// add()
		panel.add(cb_bookInfos_mini(), BorderLayout.NORTH);
		panel.add(cb_borrowAndReserve(), BorderLayout.CENTER);
		panel.add(cb_login_mini(), BorderLayout.SOUTH);
		
		return panel;
	}
	// center_box : 도서 관련 ----------------------------------------------------------------------------------------------
	public static JPanel cb_books() {
		int width = 741;
		int height = 451;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.WHITE);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		
		// add()
		panel.add(cb_searchBooks(), BorderLayout.WEST);
		panel.add(cb_books_right_box(), BorderLayout.EAST);
		
		return panel;
	}
	public static JPanel cb_books_right_box() {
		int width = 291;
		int height = 451;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, new Color(239, 237, 239)));	// 패널 테두리 설정
		
		// add()
		panel.add(cb_bookInfos(), BorderLayout.CENTER);
		panel.add(cb_modifyButtons(), BorderLayout.SOUTH);
		
		return panel;
	}
	// center_box : 사용자 관련 ---------------------------------------------------------------------------------------------
	public static JPanel cb_users() {
		int width = 741;
		int height = 451;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.WHITE);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		
		// add()
		panel.add(cb_searchUsers(), BorderLayout.WEST);
		panel.add(cb_users_right_box(), BorderLayout.EAST);
		
		return panel;
	}
	public static JPanel cb_users_right_box() {
		int width = 291;
		int height = 451;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, new Color(239, 237, 239)));	// 패널 테두리 설정
		
		// add()
		panel.add(cb_userInfos(), BorderLayout.CENTER);
		panel.add(cb_modifyButtons(), BorderLayout.SOUTH);
		
		return panel;
	}
	
	
	
	
	
	
	

	// center_box : 버튼 창 ------------------------------------------------------------------------------------------------
	public static JPanel cb_modifyButtons() {
		int width = 272;
		int height = 51;
		
		JButton btn1 = new JButton("추가");
		JButton btn2 = new JButton("삭제");
		JButton btn3 = new JButton("저장");
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);											// 패널 배경 설정
		panel.setLayout(new GridLayout(1, 3, 9, 0));						// 레이아웃 설정
		panel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));		// 패널 여백 설정
		
		// add()
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		
		return panel;
	}
	public static JPanel cb_borrowAndReserve() {
		int width = 272;
		int height = 150;
		
		JLabel la = new JLabel("해당 기능을 사용하시려면, 로그인 해야 합니다.");
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);											// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 13));						// 레이아웃 설정
		panel.setBorder(BorderFactory.createEmptyBorder(5, 8, 10, 8));		// 패널 여백 설정
		
		// add()
		panel.add(la);
		panel.add(cb_borrowAndReserve_buttons());
		
		return panel;
	}
	public static JPanel cb_borrowAndReserve_buttons() {
		int width = 252;
		int height = 65;
		
		JButton btn1 = new JButton("대출");
		JButton btn2 = new JButton("예약");
		JButton btn3 = new JButton("반납");
		JButton btn4 = new JButton("대출취소");
		JButton btn5 = new JButton("예약취소");
		JButton btn6 = new JButton("반납취소");
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);											// 패널 배경 설정
		panel.setLayout(new GridLayout(2, 3, 5, 5));						// 레이아웃 설정
		
		// add()
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		
		return panel;
	}
	// center_box : 대출 반납 -----------------------------------------------------------------------------------------------
	public static JPanel cb_bookInfos_mini() {
		int width = 272;
		int height = 170;
		
		JLabel la1 = new JLabel("도서 정보");
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);									// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));					// 레이아웃 설정
		panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));		// 패널 여백 설정
		
		// add()
		panel.add(la1);
		panel.add(cb_bookInfos_data_mini());
		
		return panel;
	}
	public static JPanel cb_bookInfos_data_mini() {
		int width = 246;
		int height = 126;
		
		// 책 정보 필드(String), 텍스트상자 크기(int)
		String[] label = {"제목 :", "저자 :", "장르 :", "책 번호 :"};
		int[] textfieldSize = {16, 16, 16, 15};
		
		// GridLayout 패널
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);
		panel.setLayout(new GridLayout(label.length, 1));
				
				
		// add()
		for (int i=0; i<label.length; i++) {	// 책 정보의 필드 수 만큼 반복
					
			// GridLayout 패널의 컴포넌트, FlowLayout 패널 
			JPanel p = new JPanel();
			p.setBackground(null);
			p.setLayout(new FlowLayout(FlowLayout.LEFT));
					
			JLabel la = new JLabel(label[i]);
			JTextField tf = new JTextField(textfieldSize[i]);
					
			p.add(la);
			p.add(tf);
			panel.add(p);
		}
				
		return panel;
	}
	public static JPanel cb_login_mini() {
		int width = 272;
		int height = 155;

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);											// 패널 배경 설정
		panel.setLayout(new BorderLayout());						// 레이아웃 설정
		panel.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, new Color(239, 237, 239)));	// 패널 테두리 설정
		
		// add()
		panel.add(cb_login_mini_textlabel(), BorderLayout.NORTH);
		panel.add(cb_login_mini_textfield(), BorderLayout.CENTER);
		panel.add(cb_login_mini_button(), BorderLayout.SOUTH);
		
		return panel;
	}
	public static JPanel cb_login_mini_textlabel() {
		int width = 272;
		int height = 37;
		
		JLabel la = new JLabel("로그아웃 됨");
		
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(width, height));
		panel.setBackground(null);
		
		// add()
		panel.add(la, BorderLayout.CENTER);
		
		return panel;
	}
	public static JPanel cb_login_mini_textfield() {
		int width = 272;
		int height = 81;
		
		// 책 정보 필드(String), 텍스트상자 크기(int)
		String[] label = {"아이디 :", "비밀번호 :"};
		int[] textfieldSize = {16, 15};
		
		// GridLayout 패널
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBorder(BorderFactory.createEmptyBorder(5, 13, 5, 13));		// 패널 여백 설정
		panel.setBackground(null);									// 패널 배경 설정
		panel.setLayout(new GridLayout(label.length, 1));
				
				
		// add()
		for (int i=0; i<label.length; i++) {	// 책 정보의 필드 수 만큼 반복
					
			// GridLayout 패널의 컴포넌트, FlowLayout 패널 
			JPanel p = new JPanel();
			p.setBackground(null);
			p.setLayout(new FlowLayout(FlowLayout.LEFT));
					
			JLabel la = new JLabel(label[i]);
			JTextField tf = new JTextField(textfieldSize[i]);
					
			p.add(la);
			p.add(tf);
			panel.add(p);
		}
				
		return panel;
	}
	public static JPanel cb_login_mini_button() {
		int width = 272;
		int height = 37;
		
		JButton btn1 = new JButton("로그인");
		JButton btn2 = new JButton("로그아웃");
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);											// 패널 배경 설정
		panel.setLayout(new GridLayout(1, 2, 9, 0));						// 레이아웃 설정
		panel.setBorder(BorderFactory.createEmptyBorder(3, 8, 3, 8));		// 패널 여백 설정
		
		// add()
		panel.add(btn1);
		panel.add(btn2);
		
		return panel;
	}
	// center_box : 도서 정보 -----------------------------------------------------------------------------------------------
	public static JScrollPane cb_bookInfos() {
		int width = 272;
		int height = 500;
		
		JLabel la1 = new JLabel("도서 정보");
		JLabel la2 = new JLabel("도서 상태");
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);									// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));					// 레이아웃 설정
		panel.setBorder(BorderFactory.createEmptyBorder(13, 10, 13, 10));		// 패널 여백 설정
		
		// add()
		panel.add(la1);
		panel.add(cb_bookInfos_data());
		panel.add(la2);
		panel.add(cb_bookInfos_state());
		
		
		JScrollPane scrolPanel = new JScrollPane(panel);
		scrolPanel.setBorder(null);
		return scrolPanel;
	}
	public static JPanel cb_bookInfos_data() {
		// 책 정보 필드(String), 텍스트상자 크기(int)
		String[] label = {"제목 :", "저자 :", "장르 :", "출판 년도 :", "책 번호 :", "책 도서관 반입일 :"};
		int[] textfieldSize = {16, 16, 16, 5, 14, 7};
		
		// GridLayout 패널
		JPanel panel = new JPanel();
		panel.setBackground(null);
		panel.setLayout(new GridLayout(label.length, 1));
		
		
		// add()
		for (int i=0; i<label.length; i++) {	// 책 정보의 필드 수 만큼 반복
			
			// GridLayout 패널의 컴포넌트, FlowLayout 패널 
			JPanel p = new JPanel();
			p.setBackground(null);
			p.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			JLabel la = new JLabel(label[i]);
			JTextField tf = new JTextField(textfieldSize[i]);
			
			p.add(la);
			p.add(tf);
			panel.add(p);
		}
		
		return panel;
	}
	public static JPanel cb_bookInfos_state() {
		// 책 상태 정보 필드(String), 텍스트상자 크기(int)
		String[] label = {"현재 대출자 :", "현재 예약자 :", "대출일 :", "반납입(연장횟수) :"};
		int[] textfieldSize = {13, 13, 7, 7};
		
		// GridLayout 패널
		JPanel panel = new JPanel();
		panel.setBackground(null);
		panel.setLayout(new GridLayout(label.length, 1));
		
		
		// add()
		for (int i=0; i<label.length; i++) {	// 책 정보의 필드 수 만큼 반복
			
			// GridLayout 패널의 컴포넌트, FlowLayout 패널 
			JPanel p = new JPanel();
			p.setBackground(null);
			p.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			JLabel la = new JLabel(label[i]);
			JTextField tf = new JTextField(textfieldSize[i]);
			
			p.add(la);
			p.add(tf);
			panel.add(p);
		}
		
		return panel;
	}
	
	// center_box : 사용자 정보 ---------------------------------------------------------------------------------------------
	public static JScrollPane cb_userInfos() {
		int width = 272;
		int height = 500;
		
		JLabel la1 = new JLabel("사용자 기본 정보");
		JLabel la2 = new JLabel("사용자 도서 대출 정보");
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);											// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));			// 레이아웃 설정
		panel.setBorder(BorderFactory.createEmptyBorder(13, 10, 13, 10));		// 패널 여백 설정
		
		// add()
		panel.add(la1);
		panel.add(cb_userInfos_data());
		panel.add(la2);
		panel.add(cb_userInfos_books());
		
		JScrollPane scrolPanel = new JScrollPane(panel);
		scrolPanel.setBorder(null);
		return scrolPanel;
	}
	public static JPanel cb_userInfos_data() {
		// 책 정보 필드(String), 텍스트상자 크기(int)
		String[] label = {"이름 :", "타입 :", "아이디 :", "비밀번호 :"};
		int[] textfieldSize = {16, 16, 15, 14};
		
		// GridLayout 패널
		JPanel panel = new JPanel();
		panel.setBackground(null);
		panel.setLayout(new GridLayout(label.length, 1));
		
		
		// add()
		for (int i=0; i<label.length; i++) {	// 사용자 기본 정보의 필드 수 만큼 반복
			
			// GridLayout 패널의 컴포넌트, FlowLayout 패널 
			JPanel p = new JPanel();
			p.setBackground(null);
			p.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			JLabel la = new JLabel(label[i]);
			JTextField tf = new JTextField(textfieldSize[i]);
			
			p.add(la);
			p.add(tf);
			panel.add(p);
		}
		
		return panel;
	}
	public static JPanel cb_userInfos_books() {
		// 책 상태 정보 필드(String), 텍스트상자 크기(int)
		String[] label = {"대출도서(3) :", "예약도서(3) :", "연체도서(2) :"};
		String[][] bookData = {
				{"book_a", "book_b", "book_c"},		// 대출 도서
				{"book_d", "book_e", "book_f"},		// 예약 도서
				{"book_a", "book_b"}				// 연체 도서
		};
		
		// GridLayout 패널
		JPanel panel = new JPanel();
		panel.setBackground(null);
		panel.setLayout(new GridLayout(label.length, 1));
		
		
		// add()
		for (int i=0; i<label.length; i++) {	// 책 정보의 필드 수 만큼 반복
			
			// GridLayout 패널의 컴포넌트, FlowLayout 패널 
			JPanel p = new JPanel();
			p.setBackground(null);
			p.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			JLabel la = new JLabel(label[i]);
			JComboBox cb = new JComboBox(bookData[i]);
			
			p.add(la);
			p.add(cb);
			panel.add(p);
		}
		
		return panel;
	}
	// center_box : 도서 검색 -----------------------------------------------------------------------------------------------
	public static JPanel cb_searchBooks() {
		int width = 450;
		int height = 451;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(new Color(249, 247, 249));						// 패널 배경 설정
		panel.setLayout(new BorderLayout(0, 15));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));	// 패널 여백 설정
		
		// add()
		panel.add(cb_searchBooks_north(), BorderLayout.NORTH);
		panel.add(cb_searchBooks_center(), BorderLayout.CENTER);
		
		return panel;
	}
	public static JPanel cb_searchBooks_north() {
		int width = 410;
		int height = 58; // 32 + 23 = 62
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));			// 패널 크기 설정
		panel.setBackground(Color.WHITE);								// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(239, 237, 239)));	// 패널 테두리 설정
		
		// add()
		panel.add(cb_searchBooks_north_box1(), BorderLayout.WEST);
		panel.add(cb_searchBooks_north_box2(), BorderLayout.EAST);
		panel.add(cb_searchBooks_north_box3(), BorderLayout.SOUTH);
		
		return panel;
	}
	public static JPanel cb_searchBooks_north_box1() {
		int width = 215;
		int height = 35;
		
		JLabel la = new JLabel("검색 :");
		JTextField tf = new JTextField(12);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));			// 패널 크기 설정
		panel.setBackground(null);								// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		// add()
		panel.add(la);
		panel.add(tf);
		
		return panel;
	}
	public static JPanel cb_searchBooks_north_box2() {
		int width = 195;
		int height = 35;
		
		JButton btn = new JButton("검색");
		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));			// 패널 크기 설정
		panel.setBackground(null);								// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		// add()
		panel.add(btn);
		
		return panel;
	}
	public static JPanel cb_searchBooks_north_box3() {
		int width = 410;
		int height = 23;
		
		String[] bookinfo = {"제목", "저자", "장르", "출판년도", "책 번호", "대출자", "예약자"};
		JCheckBox[] ch = new JCheckBox[bookinfo.length];
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));			// 패널 크기 설정
		panel.setBackground(new Color(239, 237, 239));								// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 7, 0));
		
		// add()
		for(int i=0; i<bookinfo.length; i++) {
			ch[i] = new JCheckBox(bookinfo[i]);
			//ch[i].setBorderPainted(true);
			panel.add(ch[i]);
		}
		
		return panel;
	}
	public static JPanel cb_searchBooks_center() {
		int width = 410;
		int height = 338;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));			// 패널 크기 설정
		panel.setBackground(Color.WHITE);						// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(239, 237, 239)));	// 패널 테두리 설정
		
		// add()
		panel.add(cb_searchBooks_center_table(), BorderLayout.CENTER);
		
		return panel;
	}
	public static JScrollPane cb_searchBooks_center_table() {
		String[] header = {"제목", "책 번호", "대출 가능", "예약 가능", "대출 상태", "예약 상태"};
		String[][] contents = {
			{"자료구조", "12340000", "Y", "Y", "N", "N"},
			{"이산수학", "12340001", "N" , "Y", "Y", "N"},
			{"자바", "12129999", "N", "N", "N", "Y"}
		};
		JTable table = new JTable(contents, header);
		
		JScrollPane panel = new JScrollPane(table);
		return panel;
	}
	// center_box : 사용자 검색 ---------------------------------------------------------------------------------------------
	public static JPanel cb_searchUsers() {
		int width = 450;
		int height = 451;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(new Color(249, 247, 249));						// 패널 배경 설정
		panel.setLayout(new BorderLayout(0, 15));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));	// 패널 여백 설정
		
		// add()
		panel.add(cb_searchUsers_north(), BorderLayout.NORTH);
		panel.add(cb_searchUsers_center(), BorderLayout.CENTER);
		
		return panel;
	}
	public static JPanel cb_searchUsers_north() {
		int width = 410;
		int height = 58; // 32 + 23 = 62
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));			// 패널 크기 설정
		panel.setBackground(Color.WHITE);								// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(239, 237, 239)));	// 패널 테두리 설정
		
		// add()
		panel.add(cb_searchUsers_north_box1(), BorderLayout.WEST);
		panel.add(cb_searchUsers_north_box2(), BorderLayout.EAST);
		panel.add(cb_searchUsers_north_box3(), BorderLayout.SOUTH);
		
		return panel;
	}
	public static JPanel cb_searchUsers_north_box1() {
		int width = 215;
		int height = 35;
		
		JLabel la = new JLabel("검색 :");
		JTextField tf = new JTextField(12);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));			// 패널 크기 설정
		panel.setBackground(null);								// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		// add()
		panel.add(la);
		panel.add(tf);
		
		return panel;
	}
	public static JPanel cb_searchUsers_north_box2() {
		int width = 195;
		int height = 35;
		
		JButton btn = new JButton("검색");
		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));			// 패널 크기 설정
		panel.setBackground(null);								// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		// add()
		panel.add(btn);
		
		return panel;
	}
	public static JPanel cb_searchUsers_north_box3() {
		int width = 410;
		int height = 23;
		
		String[] bookinfo = {"이름", "타입", "아이디", "대출도서", "예약도서", "연체도서"};
		JCheckBox[] ch = new JCheckBox[bookinfo.length];
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));			// 패널 크기 설정
		panel.setBackground(new Color(239, 237, 239));								// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 7, 0));
		
		// add()
		for(int i=0; i<bookinfo.length; i++) {
			ch[i] = new JCheckBox(bookinfo[i]);
			panel.add(ch[i]);
		}
		
		return panel;
	}
	public static JPanel cb_searchUsers_center() {
		int width = 410;
		int height = 338;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));			// 패널 크기 설정
		panel.setBackground(Color.WHITE);						// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(239, 237, 239)));	// 패널 테두리 설정
		
		// add()
		panel.add(cb_searchUsers_center_table(), BorderLayout.CENTER);
		
		return panel;
	}
	public static JScrollPane cb_searchUsers_center_table() {
		String[] header = {"이름", "아이디", "타입"};
		String[][] contents = {
			{"김건아", "rtguna@naver.com", "Patron"},
			{"김건모", "kimgeona77@sch.ac.kr", "Manager"},
			{"김건하", "rtguna@icloud.com", "Librarian"}
		};
		JTable table = new JTable(contents, header);
		
		JScrollPane panel = new JScrollPane(table);
		return panel;
	}
	// EmptyPanel --------------------------------------------------------------------------------------------------------
	public static JPanel EmptyPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(null);
		return panel;
	}
}
