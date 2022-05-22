package library_users;

// 사용자 : Users
// 전체 사용자 클래스
// @건아
public class Users {
	protected String id;
	protected String pw;
	protected String name;
	protected String userType;		// Patron, Librarian, Manager
	
	// 생성자, 초기화 =============================================================================================
	public Users(String id, String pw, String userType) {
		this.id = id;
		this.pw = pw;
		this.name = "unknown";
		this.userType = userType;
	}
	public Users() {
		id = null;
		pw = null;
		name = "unknown";
		userType = "unknown";
	}

	// 사용자 정보(상태) 가져오기 메소드 ==============================================================================
	public String getName() 					{return name;}				// 이름 반환 
	public String getId() 						{return id;}				// id 반환
	public String getPw()						{return pw;}				// pw 반환
	public String getUserType()					{return userType;}			// userType 반환
	
	// 사용자 정보 업데이트 메소드 ===================================================================================
	public void updateId(String id)		{this.id = id;}
	public void updatePw(String pw)		{this.pw = pw;}
	
	// 기타 메소드 ===============================================================================================
	public static String numToUserType(int i) {
		if (i == 1) return "Manager";
		else if (i == 2) return "Librarian";
		else return null;
	}
}
