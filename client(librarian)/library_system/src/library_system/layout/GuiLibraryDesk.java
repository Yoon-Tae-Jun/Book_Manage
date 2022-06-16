package library_system.layout;
import library_system.eventListener.*;
import library_books.*;
import library_users.*;

import API.*;
import java.awt.*;
import javax.swing.*;

import org.json.simple.JSONObject;

import API.Call_API;

public class GuiLibraryDesk extends JFrame{
	
	private String libraryName;
	private int width = 1000;
	private int height = 650;
	
	private Users librarian;        // 로그인 된 사서 정보
	private Users patron;			// 로그인 된 일반사용자 정보
	private Book[] books;			// 불러온 도서들
	private Book bookSelected;
	private Users[] users;			// 불러온 사용자들
	private Users userSelected;
	
	private String clickedButton;
	private int select_screen;
	private boolean btn_add_sel;
	private boolean btn_save_sel;
	//컨포넌트
	

	
	// 컴포넌트 -----------------------------------------------------------------------------------------------------------
	public JButton btn_libraryName;
	public JButton btn_myAccount;
	public JButton btn_1;
	public JButton btn_2;
	public JButton btn_3;
	public JButton btn_4;
	public JButton btn_1u;
	public JButton btn_2u;
	public JButton btn_3u;

	public JButton btn_add;
	public JButton btn_del;
	public JButton btn_save;

	public JLabel la_borrowAndReserve;
	public JLabel la_bookSearch;
	
	public JButton btn_cancel_add_save;
	public JButton btn_borrow;
	public JButton btn_reserve;
	public JButton btn_return;
	public JButton btn_cancel_borrow;
	public JButton btn_cancel_reserve;
	public JButton btn_image;
	
	public JLabel la_bookInfo;
	
			// 책 정보 필드(String), 텍스트상자 크기(int)
	public String[] la_book_info_label;
	public int[] tf_book_info_size;
	public JLabel[] la_book_info;
	public JTextField[] tf_book_info;
			

	public JLabel la_loginText;
	
	public JLabel la_login_mini_id;
	public JLabel la_login_mini_pw;
	public JTextField tf_login_mini_id;
	public JTextField tf_login_mini_pw;
	
	public JButton btn_login;
	public JButton btn_logout;
	
	public JLabel la_book_Info;
	public JLabel la_book_Statement;
		
			// 책 정보 필드(String), 텍스트상자 크기(int)
	public String[] la_book_info_2_label;
	public int[] tf_book_info_2_size;
	public JLabel[] la_book_2_info;
	public JTextField[] tf_book_2_info;
	
			// 책 정보 필드(String), 텍스트상자 크기(int)
	public String[] la_book_info_3_label;
	public int[] tf_book_info_3_size;
	public JLabel[] la_book_3_info;
	public JTextField[] tf_book_3_info;
	

	public JLabel la_userInfo;
	public JLabel la_userBookInfo;
	
		// 책 정보 필드(String), 텍스트상자 크기(int)
	public String[] la_book_info_4_label;
	public int[] tf_book_info_4_size;
	public JLabel[] la_book_4_info;
	public JTextField[] tf_book_4_info;
	
		// 책 정보 필드(String), 텍스트상자 크기(int)
	public String[] la_book_info_5_label;
	public String[][] cb_book_info_5_size;
	public JLabel[] la_book_5_info;
	public JComboBox[] cb_book_5_info;
	
	public JLabel la_search;
	public JTextField tf_search;

	public JButton btn_search;
	
	public String[] radio_name_1;
	public JRadioButton[] rb_1;
	public ButtonGroup group_1;
	
	public String[] tb_header_1;
	public String[][] tb_contents_1;
	public JTable table_1;
	
	public JLabel la_search_user;
	public JTextField tf_search_user;

	public JButton btn_search_user;
	
	public String[] radio_name_2;
	public JRadioButton[] rb_2;
	public ButtonGroup group_2;
	
	public String[] tb_header_2;
	public String[][] tb_contents_2;
	public JTable table_2;
	
	// 생성자 ------------------------------------------------------------------------------------------------------------
	public GuiLibraryDesk(Users librarian,String libraryName) {
		this.librarian = librarian;
		this.libraryName = libraryName;
		
		// 컴포넌트
		btn_libraryName = new JButton(libraryName);
		
		btn_myAccount = new JButton("계정");
		
		btn_1 = new JButton("1. 대출");
		btn_2 = new JButton("2. 반납");
		btn_3 = new JButton("3. 도서 관련");
		btn_4 = new JButton("4. 사용자 관련");
		
		btn_1u = new JButton("1. 사용자 관련 기능");
		btn_2u = new JButton("2. 사용자 관련 기능");
		btn_3u = new JButton("3. 사용자 관련 기능");
		
		btn_add = new JButton("추가");
		btn_del = new JButton("삭제");
		btn_save = new JButton("변경");
		
		la_borrowAndReserve = new JLabel("해당 기능을 사용하시려면, 로그인 해야 합니다.");
		
		btn_borrow = new JButton("대출");
		btn_reserve = new JButton("예약");
		btn_return = new JButton("반납");
		btn_cancel_borrow = new JButton("연장");
		btn_cancel_reserve = new JButton("예약취소");
		btn_image = new JButton("책 사진");
		
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
		la_book_info_2_label = new String[] {"제목 :", "저자 :", "장르 :", "출판 년도 :", "책 번호 :"};
		tf_book_info_2_size = new int[] {16, 16, 16, 5, 14};	
		la_book_2_info = new JLabel[la_book_info_2_label.length];
		tf_book_2_info = new JTextField[tf_book_info_2_size.length];
		
				// 책 상태 정보 필드(String), 텍스트상자 크기(int)
		la_book_info_3_label = new String[] {"현재 대출자 :", "현재 예약자 :", "대출일 :", "반납입(연장횟수) :"};
		tf_book_info_3_size = new int[] {13, 13, 7, 7};
		la_book_3_info = new JLabel[la_book_info_3_label.length];
		tf_book_3_info = new JTextField[tf_book_info_3_size.length];
		la_bookSearch = new JLabel("");
		
		la_userInfo = new JLabel("사용자 기본 정보");
		la_userBookInfo = new JLabel("사용자 도서 대출 정보");
		
				// 책 상태 정보 필드(String), 텍스트상자 크기(int)
		la_book_info_4_label = new String[] {"아이디 :","이름 :", "타입 :", "이메일 :", "비밀번호 :"};
		tf_book_info_4_size = new int[] {15,16, 16, 15, 14};
		la_book_4_info = new JLabel[la_book_info_4_label.length];
		tf_book_4_info = new JTextField[tf_book_info_4_size.length];
				
				// 책 상태 정보 필드(String), 텍스트상자 크기(int)
		la_book_info_5_label = new String[] {"대출도서(3) :", "예약도서(3) :", "연체도서(2) :"};
		cb_book_info_5_size = new String[][] {
									{"     ","","" },		// 대출 도서
									{"     ","",""},		// 예약 도서
									{"     ","",""}				// 연체 도서
		};
		la_book_5_info = new JLabel[la_book_info_5_label.length];
		cb_book_5_info = new JComboBox[cb_book_info_5_size.length];
				
		la_search = new JLabel("검색 :");
		tf_search = new JTextField(12);
		
		btn_search = new JButton("검색");
		
		radio_name_1 = new String[] {"제목", "저자","장르","출판년도", "책 번호"};
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
		tb_contents_2 = new String[][] {};
		table_2 = new JTable(tb_contents_2, tb_header_2);
		
		// event
		//btn_libraryName.addMouseListener(new GoToMain(this));	// 메인 페이지로 이동 (도서)
		//btn_myAccount.addMouseListener(new GoToMain2(this));		// 메인 페이지로 이동 (사용자)
		
		//btn_1.addMouseListener(new ChangeCenterBox(this));
		//btn_2.addMouseListener(new ChangeCenterBox(this));
		//btn_3.addMouseListener(new ChangeCenterBox(this));
		
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
		panel.add(center_box(), BorderLayout.CENTER); // center_box(), cb_borrow() cb_return(), cb_books(), cb_users()
		
		
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
		panel.add(btn_4);
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
	// center_box : 대출 ---------------------------------------------------------------------------------------------
	public JPanel cb_borrow() {
		int width = 741;
		int height = 451;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.WHITE);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		
		// add()
		panel.add(cb_searchBooks(), BorderLayout.WEST);
		panel.add(cb_borrow_right_box(), BorderLayout.EAST);
		
		return panel;
	}
	public JPanel cb_borrow_right_box() {
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
	// center_box : 반납 ---------------------------------------------------------------------------------------------
	public JPanel cb_return() {
		int width = 741;
		int height = 451;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.WHITE);									// 패널 배경 설정
		panel.setLayout(new BorderLayout());
		
		// add()
		panel.add(cb_searchBooks(), BorderLayout.WEST);
		panel.add(cb_return_right_box(), BorderLayout.EAST);
		
		return panel;
	}
	public JPanel cb_return_right_box() {
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
		panel.setBackground(Color.WHITE);									// 패널 배경 설정
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
	
	public JPanel cb_bookSearch() {
		int width = 272;
		int height = 100;
		
		JPanel panel = new JPanel();			
		btn_cancel_add_save = new JButton("취소");
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(null);											// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));						// 레이아웃 설정
		panel.setBorder(BorderFactory.createEmptyBorder(0, 8, 10, 8));		// 패널 여백 설정

		btn_cancel_add_save.setVisible(false);
		// add()
		panel.add(la_bookSearch);
		panel.add(btn_cancel_add_save);
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
		panel.add(btn_image);
		
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
		int width = 270;
		int height = 500;
		
		JPanel panel = new JPanel();
		
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.WHITE);									// 패널 배경 설정
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));					// 레이아웃 설정
		panel.setBorder(BorderFactory.createEmptyBorder(13, 10, 13, 10));		// 패널 여백 설정
		
		// add()
		panel.add(la_book_Info);
		panel.add(cb_bookInfos_data());
		panel.add(la_book_Statement);
		panel.add(cb_bookInfos_state());
		panel.add(cb_bookSearch());
		
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
			tf_book_2_info[i].setEnabled(false); 	// 텍스트 필드 비활성화
			
			p.add(la_book_2_info[i]);
			p.add(tf_book_2_info[i]);
			panel.add(p);
		}
		
		return panel;
	}
	public void bookTextEnabled() {
		for (int i=0; i<3; i++) {	// 책 정보의 필드 수 만큼 반복
			tf_book_2_info[i].setEnabled(true); 	// 텍스트 필드 비활성화
		}
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
			tf_book_3_info[i].setEnabled(false); 	// 텍스트 필드 비활성화
			
			p.add(la_book_3_info[i]);
			p.add(tf_book_3_info[i]);
			panel.add(p);
		}
		
		return panel;
	}

	// center_box : 사용자 정보 ---------------------------------------------------------------------------------------------
	public JScrollPane cb_userInfos() {
		int width = 270;
		int height = 500;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));				// 패널 크기 설정
		panel.setBackground(Color.WHITE);											// 패널 배경 설정
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
			tf_book_4_info[i].setEnabled(false); 	// 텍스트 필드 비활성화
			
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
		
		btn_cancel_add_save = new JButton("취소");
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
		panel.add(panel)
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
			rb_1[i].setActionCommand(radio_name_1[i]);
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
			rb_2[i].setActionCommand(radio_name_2[i]);
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

	// JTable 업데이트 : 데이터(Book[], Users[]) JTable에 채우기
	public void updateJTableBooks() {
		
		if (books != null) {
			tb_contents_1 = new String[books.length][tb_header_1.length];
			for(int i=0; i<books.length; i++) {
				// tb_contents_1에다 필요한 책 정보 String 형태로 저장
				String bookNmae = books[i].getIb().getName();	// 제목
				String bookId = books[i].getIb().getId();		// 책 번호
					// !대출중 && !예약중
				String borrowState = "N";							// 대출 가능
				String reserveState = "N";							// 예약 가능
				String canBorrow = "Y";								// 대출 상태
				String canReserve = "Y";							// 예약 상태
				
				boolean isBorrowed = books[i].getIbs().isBorrowed();
				boolean isReserved = books[i].getIbs().isReserved();
				
				if(isBorrowed) {		// 대출중 && !예약중
					borrowState = "Y";
					reserveState = "N";
					canBorrow = "N";
					canReserve = "Y";
					if(isReserved) {	// 대출중 && 예약중
						reserveState = "Y";
						canReserve = "N";
					}
				}
				else if(isReserved) {	// !대출중 && 예약중
					borrowState = "N";
					reserveState = "Y";
					canBorrow = "N";
					canReserve = "N";
				}
				
				tb_contents_1[i][0] = bookNmae;
				tb_contents_1[i][1] = bookId;
				tb_contents_1[i][2] = borrowState;
				tb_contents_1[i][3] = reserveState;
				tb_contents_1[i][4] = canBorrow;
				tb_contents_1[i][5] = canReserve;
			}
			// 새로운 테이블 저장
			setTable_1(new JTable(tb_contents_1, tb_header_1));
		}
		else {
			setTable_1(new JTable(new String[][]{}, tb_header_1));
		}
		
		
	}
	public void updateJTableUsers() {
		tb_contents_2 = new String[users.length][tb_header_2.length];
		for(int i=0; i<users.length; i++) {
			// tb_contents_1에다 필요한 책 정보 String 형태로 저장
			String userName = users[i].getName();		// 이름 
			String userId = users[i].getId();			// 아이디 
			String userType = users[i].getUserType();	// 타입
			
			tb_contents_2[i][0] = userName;
			tb_contents_2[i][1] = userId;
			tb_contents_2[i][2] = userType;
		}
		// 새로운 테이블 저장
		table_2 = new JTable(tb_contents_2, tb_header_2);
	}

	// JButton 화성화
	public void btn1_enabled() {		// 1. 대출 버튼
		// 검색 버튼
		tf_search.setEnabled(true);
		btn_search.setEnabled(true);
		// 대출 반납 예약 버튼
		btn_borrow.setEnabled(false);			// 로그인시 활성화
		btn_reserve.setEnabled(false);			// 로그인시 활성화
		btn_return.setEnabled(false);
		btn_cancel_borrow.setEnabled(false);	// 로그인시 활성화
		btn_cancel_reserve.setEnabled(false);	// 로그인시 활성화
		btn_image.setEnabled(true);
		// 로그인 버튼
		btn_login.setEnabled(true);
		btn_logout.setEnabled(false);		// 로그인시 활성화
		// 텍스트 필드 설정
		la_borrowAndReserve.setText("해당 기능을 사용하시려면, 로그인 해야 합니다.");
		la_loginText.setText("로그아웃 됨");
	}
	public void btn1_enabled_loggedin() {		// 1. 대출 버튼
		// 검색 버튼
		tf_search.setEnabled(true);
		btn_search.setEnabled(true);
		// 대출 반납 예약 버튼
		btn_borrow.setEnabled(true);			// 로그인시 활성화
		btn_reserve.setEnabled(true);			// 로그인시 활성화
		btn_return.setEnabled(false);
		btn_cancel_borrow.setEnabled(true);		// 로그인시 활성화
		btn_cancel_reserve.setEnabled(true);	// 로그인시 활성화
		btn_image.setEnabled(true);
		// 로그인 버튼
		btn_login.setEnabled(false);
		btn_logout.setEnabled(true);		// 로그인시 활성화
		// 텍스트 필드 설정
		la_borrowAndReserve.setText("");
		la_loginText.setText("어서오세요 " + patron.getName() + "님");
		la_loginText.setForeground(Color.BLACK);
	}
	public void btn2_enabled() {		// 2. 반납 버튼
		// 검색 버튼
		tf_search.setEnabled(false);
		btn_search.setEnabled(false);
		// 대출 반납 예약 버튼
		btn_borrow.setEnabled(false);	
		btn_reserve.setEnabled(false);			// 로그인시 활성화
		btn_return.setEnabled(false);			// 로그인시 활성화
		btn_cancel_borrow.setEnabled(false);
		btn_cancel_reserve.setEnabled(false);	// 로그인시 활성화
		btn_image.setEnabled(true);	// 로그인시 활성화
		// 로그인 버튼
		btn_login.setEnabled(true);
		btn_logout.setEnabled(false);		// 로그인시 활성화
		// 텍스트 필드 설정
		la_borrowAndReserve.setText("해당 기능을 사용하시려면, 로그인 해야 합니다.");
		la_loginText.setText("로그아웃 됨");
	}
	public void btn2_enabled_loggedin() {		// 2. 반납 버튼
		// 검색 버튼
		tf_search.setEnabled(false);
		btn_search.setEnabled(false);
		// 대출 반납 예약 버튼
		btn_borrow.setEnabled(false);	
		btn_reserve.setEnabled(false);			// 로그인시 활성화
		btn_return.setEnabled(true);			// 로그인시 활성화
		btn_cancel_borrow.setEnabled(false);
		btn_cancel_reserve.setEnabled(false);	// 로그인시 활성화
		btn_image.setEnabled(true);	// 로그인시 활성화
		// 로그인 버튼
		btn_login.setEnabled(false);
		btn_logout.setEnabled(true);		// 로그인시 활성화
		// 텍스트 필드 설정
		la_borrowAndReserve.setText("");
		la_loginText.setText("어서오세요 " + patron.getName() + "님");
	}
	public void btn3_enabled() {		// 3. 도서 관련 버튼
		// 검색 버튼
		tf_search.setEnabled(true);
		btn_search.setEnabled(true);
		
		btn_add.setEnabled(true);
		btn_del.setEnabled(true);
		btn_save.setEnabled(true);
	}		
	public void btn4_enabled() {		// 4. 사용자 관련 버튼
		// 검색 버튼
		tf_search.setEnabled(true);
		btn_search.setEnabled(true);
		
		btn_add.setEnabled(true);
		btn_del.setEnabled(true);
		btn_save.setEnabled(true);
	}
	
	//getter, setter
	public Book[] getBooks() {
		return books;
	}

	public void setBooks(Book[] books) {
		this.books = books;
	}

	public Book getBookSelected() {
		return bookSelected;
	}

	public void setBookSelected(Book bookSelected) {
		this.bookSelected = bookSelected;
	}

	public Users[] getUsers() {
		return users;
	}

	public void setUsers(Users[] users) {
		this.users = users;
	}

	public Users getUserSelected() {
		return userSelected;
	}

	public void setUserSelected(Users userSelected) {
		this.userSelected = userSelected;
	}
	
	public Users getPatron() {
		return patron;
	}

	public void setPatron(Users patron) {
		this.patron = patron;
	}
	
	public String getClickedButton() {
		return clickedButton;
	}

	public void setClickedButton(String clickedButton) {
		this.clickedButton = clickedButton;
	}

	public JTable getTable_1() {
		return table_1;
	}

	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}

	public JTable getTable_2() {
		return table_2;
	}

	public void setTable_2(JTable table_2) {
		this.table_2 = table_2;
	}

	public JButton getBtn_1() {
		return btn_1;
	}

	public void setBtn_1(JButton btn_1) {
		this.btn_1 = btn_1;
	}

	public JButton getBtn_2() {
		return btn_2;
	}

	public void setBtn_2(JButton btn_2) {
		this.btn_2 = btn_2;
	}

	public JButton getBtn_3() {
		return btn_3;
	}

	public void setBtn_3(JButton btn_3) {
		this.btn_3 = btn_3;
	}

	public JButton getBtn_4() {
		return btn_4;
	}

	public void setBtn_4(JButton btn_4) {
		this.btn_4 = btn_4;
	}

	public int getSelect_screen() {
		return select_screen;
	}

	public void setSelect_screen(int select_screen) {
		this.select_screen = select_screen;
	}

	public boolean getBtn_save_sel() {
		return btn_save_sel;
	}

	public void setBtn_save_sel(boolean btn_save_sel) {
		this.btn_save_sel = btn_save_sel;
	}

	public boolean getBtn_add_sel() {
		return btn_add_sel;
	}

	public void setBtn_add_sel(boolean btn_add_sel) {
		this.btn_add_sel = btn_add_sel;
	}
	
}