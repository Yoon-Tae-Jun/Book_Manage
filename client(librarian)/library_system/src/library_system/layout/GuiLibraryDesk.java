package library_system.layout;
import library_system.eventListener.*;
import API.*;
import java.awt.*;
import javax.swing.*;

import org.json.simple.JSONObject;

import API.Call_API;

public class GuiLibraryDesk extends JFrame{
	
	private String libraryName;
	private int width = 1000;
	private int height = 650;
	
	//컨포넌트
	
	// GUI test
	public static void main(String[] args) {
		new GuiLibraryDesk("CSE Library");
	}
	
	// 컴포넌트 -----------------------------------------------------------------------------------------------------------
	JButton btn_libraryName;
	JButton btn_myAccount;
	JButton btn_1;
	JButton btn_2;
	JButton btn_3;
	JButton btn_1u;
	JButton btn_2u;
	JButton btn_3u;

	JButton btn_add;
	JButton btn_del;
	JButton btn_save;

	JLabel la_borrowAndReserve;
	
	JButton btn_borrow;
	JButton btn_reserve;
	JButton btn_return;
	JButton btn_cancel_borrow;
	JButton btn_cancel_reserve;
	JButton btn_cancel_return;
	
	JLabel la_bookInfo;
	
			// 책 정보 필드(String), 텍스트상자 크기(int)
	String[] la_book_info_label;
	int[] tf_book_info_size;
	JLabel[] la_book_info;
	JTextField[] tf_book_info;
			

	JLabel la_loginText;
	
	JLabel la_login_mini_id;
	JLabel la_login_mini_pw;
	JTextField tf_login_mini_id;
	JTextField tf_login_mini_pw;
	
	JButton btn_login;
	JButton btn_logout;
	
	JLabel la_book_Info;
	JLabel la_book_Statement;
		
			// 책 정보 필드(String), 텍스트상자 크기(int)
	String[] la_book_info_2_label;
	int[] tf_book_info_2_size;
	JLabel[] la_book_2_info;
	JTextField[] tf_book_2_info;
	
			// 책 정보 필드(String), 텍스트상자 크기(int)
	String[] la_book_info_3_label;
	int[] tf_book_info_3_size;
	JLabel[] la_book_3_info;
	JTextField[] tf_book_3_info;
	

	JLabel la_userInfo;
	JLabel la_userBookInfo;
	
		// 책 정보 필드(String), 텍스트상자 크기(int)
	String[] la_book_info_4_label;
	int[] tf_book_info_4_size;
	JLabel[] la_book_4_info;
	JTextField[] tf_book_4_info;
	
		// 책 정보 필드(String), 텍스트상자 크기(int)
	String[] la_book_info_5_label;
	String[][] cb_book_info_5_size;
	JLabel[] la_book_5_info;
	JComboBox[] cb_book_5_info;
	
	JLabel la_search;
	JTextField tf_search;

	JButton btn_search;
	
	String[] radio_name_1;
	JRadioButton[] rb_1;
	ButtonGroup group_1;
	
	String[] tb_header_1;
	String[][] tb_contents_1;
	JTable table_1;
	
	JLabel la_search_user;
	JTextField tf_search_user;

	JButton btn_search_user;
	
	String[] radio_name_2;
	JRadioButton[] rb_2;
	ButtonGroup group_2;
	
	String[] tb_header_2;
	String[][] tb_contents_2;
	JTable table_2;
	
	// 생성자 ------------------------------------------------------------------------------------------------------------
	public GuiLibraryDesk(String libraryName) {
		this.libraryName = libraryName;
		
		// 컴포넌트
		btn_libraryName = new JButton(libraryName);
		
		btn_myAccount = new JButton("내 계정");
		
		btn_1 = new JButton("1. 대출, 반납");
		btn_2 = new JButton("2. 도서 관련");
		btn_3 = new JButton("3. 사용자 관련");
		
		btn_1u = new JButton("1. 사용자 관련 기능");
		btn_2u = new JButton("2. 사용자 관련 기능");
		btn_3u = new JButton("3. 사용자 관련 기능");
		
		btn_add = new JButton("추가");
		btn_del = new JButton("삭제");
		btn_save = new JButton("저장");
		
		la_borrowAndReserve = new JLabel("해당 기능을 사용하시려면, 로그인 해야 합니다.");
		
		btn_borrow = new JButton("대출");
		btn_reserve = new JButton("예약");
		btn_return = new JButton("반납");
		btn_cancel_borrow = new JButton("대출취소");
		btn_cancel_reserve = new JButton("예약취소");
		btn_cancel_return = new JButton("반납취소");
		
		la_bookInfo = new JLabel("도서 정보");
		
				// 책 정보 필드(String), 텍스트상자 크기(int)
		la_book_info_label = new String[] {"제목 :", "저자 :", "장르 :", "책 번호 :"};
		tf_book_info_size = new int[] {16, 16, 16, 15};	
		la_book_info = new JLabel[la_book_info_label.length];
		tf_book_info = new JTextField[tf_book_info_size.length];
		
		la_loginText = new JLabel("로그아웃 됨");
		
		la_login_mini_id = new JLabel("아이디 :");
		la_login_mini_pw = new JLabel("비밀번호 :");
		tf_login_mini_id = new JTextField(16);
		tf_login_mini_pw = new JTextField(15);
		
		btn_login = new JButton("로그인");
		btn_logout = new JButton("로그아웃");
		
		la_book_Info = new JLabel("도서 정보");
		la_book_Statement = new JLabel("도서 상태");
		
				// 책 정보 필드(String), 텍스트상자 크기(int)
		la_book_info_2_label = new String[] {"제목 :", "저자 :", "장르 :", "출판 년도 :", "책 번호 :", "책 도서관 반입일 :"};
		tf_book_info_2_size = new int[] {16, 16, 16, 5, 14, 7};	
		la_book_2_info = new JLabel[la_book_info_2_label.length];
		tf_book_2_info = new JTextField[tf_book_info_2_size.length];
		
				// 책 상태 정보 필드(String), 텍스트상자 크기(int)
		la_book_info_3_label = new String[] {"현재 대출자 :", "현재 예약자 :", "대출일 :", "반납입(연장횟수) :"};
		tf_book_info_3_size = new int[] {13, 13, 7, 7};
		la_book_3_info = new JLabel[la_book_info_3_label.length];
		tf_book_3_info = new JTextField[tf_book_info_3_size.length];
		
		la_userInfo = new JLabel("사용자 기본 정보");
		la_userBookInfo = new JLabel("사용자 도서 대출 정보");
		
				// 책 상태 정보 필드(String), 텍스트상자 크기(int)
		la_book_info_4_label = new String[] {"이름 :", "타입 :", "아이디 :", "비밀번호 :"};
		tf_book_info_4_size = new int[] {16, 16, 15, 14};
		la_book_4_info = new JLabel[la_book_info_4_label.length];
		tf_book_4_info = new JTextField[tf_book_info_4_size.length];
				
				// 책 상태 정보 필드(String), 텍스트상자 크기(int)
		la_book_info_5_label = new String[] {"대출도서(3) :", "예약도서(3) :", "연체도서(2) :"};
		cb_book_info_5_size = new String[][] {
									{"book_a", "book_b", "book_c"},		// 대출 도서
									{"book_d", "book_e", "book_f"},		// 예약 도서
									{"book_a", "book_b"}				// 연체 도서
		};
		la_book_5_info = new JLabel[la_book_info_5_label.length];
		cb_book_5_info = new JComboBox[cb_book_info_5_size.length];
				
		la_search = new JLabel("검색 :");
		tf_search = new JTextField(12);
		
		btn_search = new JButton("검색");
		
		radio_name_1 = new String[] {"제목", "저자", "장르", "출판년도", "책 번호", "대출자", "예약자"};
		rb_1 = new JRadioButton[radio_name_1.length];
		group_1 = new ButtonGroup();
		
		tb_header_1 = new String[] {"제목", "책 번호", "대출 가능", "예약 가능", "대출 상태", "예약 상태"};
		tb_contents_1 = new String[][]{};
		//tb_contents_1 = APIMethod.getBooksData(tb_header_1);
		table_1 = new JTable(tb_contents_1, tb_header_1);
		
		la_search_user = new JLabel("검색 :");
		tf_search_user = new JTextField(12);
		
		btn_search_user = new JButton("검색");
		
		radio_name_2 = new String[] {"이름", "타입", "아이디", "대출도서", "예약도서", "연체도서"};
		rb_2 = new JRadioButton[radio_name_2.length];
		group_2 = new ButtonGroup();
		
		tb_header_2 = new String[] {"이름", "아이디", "타입"};
		tb_contents_2 = new String[][] {
			{"김건아", "rtguna@naver.com", "Patron"},
			{"김건모", "kimgeona77@sch.ac.kr", "Manager"},
			{"김건하", "rtguna@icloud.com", "Librarian"}
		};
		table_2 = new JTable(tb_contents_2, tb_header_2);
		
		// event
		btn_libraryName.addMouseListener(new GoToMain(this));
		btn_1.addMouseListener(new ChangeCenterBox(this));
		btn_2.addMouseListener(new ChangeCenterBox(this));
		btn_3.addMouseListener(new ChangeCenterBox(this));
		
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
	public JPanel pos_center(int pWidth, int pHeight) {
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
	public JPanel north_box() {
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
	public JPanel north_left_box() {
		int width = 801;
		int height = 60;
				
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);											// 패널 배경 설정
		panel.setLayout(new GridLayout(1, 5, 10, 0));
		
		// add()
		panel.add(btn_libraryName);
		panel.add(EmptyPanel());
		panel.add(EmptyPanel());
		panel.add(EmptyPanel());
		panel.add(EmptyPanel());
		
		return panel;
	}
	public JPanel north_right_box() {
		int width = 60;
		int height = 60;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);											// 패널 배경 설정
		panel.setLayout(new GridLayout(1, 1));
		
		// add()
		panel.add(btn_myAccount);
				
		return panel;
	}
	// west_box ----------------------------------------------------------------------------------------------------------
	public JPanel west_box_library() {
		int width = 150;
		int height = 460;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.WHITE);											// 패널 배경 설정
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	// 패널 여백 설정
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 8));
		
		// add()
		panel.add(btn_1);
		panel.add(btn_2);
		panel.add(btn_3);
		return panel;
	}
	public JPanel west_box_user() {
		int width = 150;
		int height = 460;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.WHITE);											// 패널 배경 설정
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	// 패널 여백 설정
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 8));
		
		// add()
		panel.add(btn_1u);
		panel.add(btn_2u);
		panel.add(btn_3u);
		return panel;
	}
	// center_box --------------------------------------------------------------------------------------------------------
	public JPanel center_box() {
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
	public JPanel cb_borrowAndReturn() {
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
	public JPanel cb_borrowAndReturn_right_box() {
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
	public JPanel cb_books() {
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
	public JPanel cb_books_right_box() {
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
	public JPanel cb_users() {
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
	public JPanel cb_users_right_box() {
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
	public JPanel cb_modifyButtons() {
		int width = 272;
		int height = 51;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);											// 패널 배경 설정
		panel.setLayout(new GridLayout(1, 3, 9, 0));						// 레이아웃 설정
		panel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));		// 패널 여백 설정
		
		// add()
		panel.add(btn_add);
		panel.add(btn_del);
		panel.add(btn_save);
		
		return panel;
	}
	public JPanel cb_borrowAndReserve() {
		int width = 272;
		int height = 150;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);											// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 13));						// 레이아웃 설정
		panel.setBorder(BorderFactory.createEmptyBorder(5, 8, 10, 8));		// 패널 여백 설정
		
		// add()
		panel.add(la_borrowAndReserve);
		panel.add(cb_borrowAndReserve_buttons());
		
		return panel;
	}
	public JPanel cb_borrowAndReserve_buttons() {
		int width = 252;
		int height = 65;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);											// 패널 배경 설정
		panel.setLayout(new GridLayout(2, 3, 5, 5));						// 레이아웃 설정
		
		// add()
		panel.add(btn_borrow);
		panel.add(btn_reserve);
		panel.add(btn_return);
		panel.add(btn_cancel_borrow);
		panel.add(btn_cancel_reserve);
		panel.add(btn_cancel_return);
		
		return panel;
	}
	// center_box : 대출 반납 -----------------------------------------------------------------------------------------------
	public JPanel cb_bookInfos_mini() {
		int width = 272;
		int height = 170;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);									// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));					// 레이아웃 설정
		panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));		// 패널 여백 설정
		
		// add()
		panel.add(la_bookInfo);
		panel.add(cb_bookInfos_data_mini());
		
		return panel;
	}
	public JPanel cb_bookInfos_data_mini() {
		int width = 246;
		int height = 126;
		
		// GridLayout 패널
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);
		panel.setLayout(new GridLayout(la_book_info_label.length, 1));
				
				
		// add()
		for (int i=0; i<la_book_info_label.length; i++) {	// 책 정보의 필드 수 만큼 반복
					
			// GridLayout 패널의 컴포넌트, FlowLayout 패널 
			JPanel p = new JPanel();
			p.setBackground(null);
			p.setLayout(new FlowLayout(FlowLayout.LEFT));
					
			la_book_info[i] = new JLabel(la_book_info_label[i]);
			tf_book_info[i] = new JTextField(tf_book_info_size[i]);
					
			p.add(la_book_info[i]);
			p.add(tf_book_info[i]);
			panel.add(p);
		}
				
		return panel;
	}
	public JPanel cb_login_mini() {
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
	public JPanel cb_login_mini_textlabel() {
		int width = 272;
		int height = 37;
		
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(width, height));
		panel.setBackground(null);
		
		// add()
		panel.add(la_loginText, BorderLayout.CENTER);
		
		return panel;
	}
	public JPanel cb_login_mini_textfield() {
		int width = 272;
		int height = 81;
		
		// GridLayout 패널
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBorder(BorderFactory.createEmptyBorder(5, 13, 5, 13));		// 패널 여백 설정
		panel.setBackground(null);									// 패널 배경 설정
		panel.setLayout(new GridLayout(2, 1));
				
		// add()
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.setBackground(null);
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p2.setBackground(null);
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		p1.add(la_login_mini_id);
		p1.add(tf_login_mini_id);
		p2.add(la_login_mini_pw);
		p2.add(tf_login_mini_pw);
		
		panel.add(p1);
		panel.add(p2);
				
		return panel;
	}
	public JPanel cb_login_mini_button() {
		int width = 272;
		int height = 37;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);											// 패널 배경 설정
		panel.setLayout(new GridLayout(1, 2, 9, 0));						// 레이아웃 설정
		panel.setBorder(BorderFactory.createEmptyBorder(3, 8, 3, 8));		// 패널 여백 설정
		
		// add()
		panel.add(btn_login);
		panel.add(btn_logout);
		
		return panel;
	}
	// center_box : 도서 정보 -----------------------------------------------------------------------------------------------
	public JScrollPane cb_bookInfos() {
		int width = 272;
		int height = 500;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);									// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));					// 레이아웃 설정
		panel.setBorder(BorderFactory.createEmptyBorder(13, 10, 13, 10));		// 패널 여백 설정
		
		// add()
		panel.add(la_book_Info);
		panel.add(cb_bookInfos_data());
		panel.add(la_book_Statement);
		panel.add(cb_bookInfos_state());
		
		
		JScrollPane scrolPanel = new JScrollPane(panel);
		scrolPanel.setBorder(null);
		return scrolPanel;
	}
	public JPanel cb_bookInfos_data() {
		// 책 정보 필드(String), 텍스트상자 크기(int)
		
		// GridLayout 패널
		JPanel panel = new JPanel();
		panel.setBackground(null);
		panel.setLayout(new GridLayout(la_book_info_2_label.length, 1));
	
		// add()
		for (int i=0; i<la_book_info_2_label.length; i++) {	// 책 정보의 필드 수 만큼 반복
			
			// GridLayout 패널의 컴포넌트, FlowLayout 패널 
			JPanel p = new JPanel();
			p.setBackground(null);
			p.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			la_book_2_info[i] = new JLabel(la_book_info_2_label[i]);
			tf_book_2_info[i] = new JTextField(tf_book_info_2_size[i]);
			
			p.add(la_book_2_info[i]);
			p.add(tf_book_2_info[i]);
			panel.add(p);
		}
		
		return panel;
	}
	public JPanel cb_bookInfos_state() {
		
		// GridLayout 패널
		JPanel panel = new JPanel();
		panel.setBackground(null);
		panel.setLayout(new GridLayout(la_book_info_3_label.length, 1));
		
		
		// add()
		for (int i=0; i<la_book_info_3_label.length; i++) {	// 책 정보의 필드 수 만큼 반복
			
			// GridLayout 패널의 컴포넌트, FlowLayout 패널 
			JPanel p = new JPanel();
			p.setBackground(null);
			p.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			la_book_3_info[i] = new JLabel(la_book_info_3_label[i]);
			tf_book_3_info[i] = new JTextField(tf_book_info_3_size[i]);
			
			p.add(la_book_3_info[i]);
			p.add(tf_book_3_info[i]);
			panel.add(p);
		}
		return panel;
	}
	
	// center_box : 사용자 정보 ---------------------------------------------------------------------------------------------
	public JScrollPane cb_userInfos() {
		int width = 272;
		int height = 500;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);											// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));			// 레이아웃 설정
		panel.setBorder(BorderFactory.createEmptyBorder(13, 10, 13, 10));		// 패널 여백 설정
		
		// add()
		panel.add(la_userInfo);
		panel.add(cb_userInfos_data());
		panel.add(la_userBookInfo);
		panel.add(cb_userInfos_books());
		
		JScrollPane scrolPanel = new JScrollPane(panel);
		scrolPanel.setBorder(null);
		return scrolPanel;
	}
	public JPanel cb_userInfos_data() {
		
		// GridLayout 패널
		JPanel panel = new JPanel();
		panel.setBackground(null);
		panel.setLayout(new GridLayout(la_book_info_4_label.length, 1));
		
		
		// add()
		for (int i=0; i<la_book_info_4_label.length; i++) {	// 책 정보의 필드 수 만큼 반복
			
			// GridLayout 패널의 컴포넌트, FlowLayout 패널 
			JPanel p = new JPanel();
			p.setBackground(null);
			p.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			la_book_4_info[i] = new JLabel(la_book_info_4_label[i]);
			tf_book_4_info[i] = new JTextField(tf_book_info_4_size[i]);
			
			p.add(la_book_4_info[i]);
			p.add(tf_book_4_info[i]);
			panel.add(p);
		}
		
		return panel;
	}
	public JPanel cb_userInfos_books() {
		
		// GridLayout 패널
		JPanel panel = new JPanel();
		panel.setBackground(null);
		panel.setLayout(new GridLayout(la_book_info_5_label.length, 1));
		
		
		// add()
		for (int i=0; i<la_book_info_5_label.length; i++) {	// 책 정보의 필드 수 만큼 반복
			
			// GridLayout 패널의 컴포넌트, FlowLayout 패널 
			JPanel p = new JPanel();
			p.setBackground(null);
			p.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			la_book_5_info[i] = new JLabel(la_book_info_5_label[i]);
			cb_book_5_info[i] = new JComboBox(cb_book_info_5_size[i]);
			
			p.add(la_book_5_info[i]);
			p.add(cb_book_5_info[i]);
			panel.add(p);
		}
		
		return panel;
	}
	// center_box : 도서 검색 -----------------------------------------------------------------------------------------------
	public JPanel cb_searchBooks() {
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
	public JPanel cb_searchBooks_north() {
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
	public JPanel cb_searchBooks_north_box1() {
		int width = 215;
		int height = 35;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));			// 패널 크기 설정
		panel.setBackground(null);								// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		// add()
		panel.add(la_search);
		panel.add(tf_search);
		
		return panel;
	}
	public JPanel cb_searchBooks_north_box2() {
		int width = 195;
		int height = 35;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));			// 패널 크기 설정
		panel.setBackground(null);								// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		// add()
		panel.add(btn_search);
		
		return panel;
	}
	public JPanel cb_searchBooks_north_box3() {
		int width = 410;
		int height = 23;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));			// 패널 크기 설정
		panel.setBackground(new Color(239, 237, 239));								// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 7, 0));
		
		// add()
		for(int i=0; i<radio_name_1.length; i++) {
			rb_1[i] = new JRadioButton(radio_name_1[i]);
			group_1.add(rb_1[i]);
			panel.add(rb_1[i]);
		}
		
		rb_1[0].setSelected(true);	// 첫번째 버튼 선택
		
		return panel;
	}
	public JPanel cb_searchBooks_center() {
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
	public JScrollPane cb_searchBooks_center_table() {
		JScrollPane panel = new JScrollPane(table_1);
		return panel;
	}
	// center_box : 사용자 검색 ---------------------------------------------------------------------------------------------
	public JPanel cb_searchUsers() {
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
	public JPanel cb_searchUsers_north() {
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
	public JPanel cb_searchUsers_north_box1() {
		int width = 215;
		int height = 35;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));			// 패널 크기 설정
		panel.setBackground(null);								// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		// add()
		panel.add(la_search_user);
		panel.add(tf_search_user);
		
		return panel;
	}
	public JPanel cb_searchUsers_north_box2() {
		int width = 195;
		int height = 35;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));			// 패널 크기 설정
		panel.setBackground(null);								// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		// add()
		panel.add(btn_search_user);
		
		return panel;
	}
	public JPanel cb_searchUsers_north_box3() {
		int width = 410;
		int height = 23;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));			// 패널 크기 설정
		panel.setBackground(new Color(239, 237, 239));								// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 7, 0));
		
		// add()
		for(int i=0; i<radio_name_2.length; i++) {
			rb_2[i] = new JRadioButton(radio_name_2[i]);
			group_2.add(rb_2[i]);
			panel.add(rb_2[i]);
		}
		
		rb_2[0].setSelected(true);	// 첫번째 버튼 선택
		
		return panel;
	}
	public JPanel cb_searchUsers_center() {
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
	public JScrollPane cb_searchUsers_center_table() {
		JScrollPane panel = new JScrollPane(table_2);
		return panel;
	}
	// EmptyPanel --------------------------------------------------------------------------------------------------------
	public JPanel EmptyPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(null);
		return panel;
	}
}