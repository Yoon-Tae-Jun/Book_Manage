package library_users;

public class Users {
	protected String id;
	protected String pw;
	protected String name;
	
	public Users(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	// 같은 사용자인지 확인하는 메소드 ==================================================================================
	public boolean isSameUser(Users p) {
		// 아이디랑(id), 비밀번호(pw)를 확인하여 같은사람인지 아닌지 확인
		if(id != p.id) return false;
		if(pw != p.pw) return false;
		return true;
	}
}
